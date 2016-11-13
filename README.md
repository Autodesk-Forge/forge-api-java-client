# Forge Java SDK

## Overview
This [Java](https://java.com/) SDK enables you to easily integrate the Forge REST APIs into your application,
including <a href="https://developer.autodesk.com/en/docs/oauth/v2/overview/" target="_blank">OAuth</a>, <a href="https://developer.autodesk.com/en/docs/data/v2/overview/" target="_blank">Data Management</a>, <a href="https://developer.autodesk.com/en/docs/model-derivative/v2/overview/" target="_blank">Model Derivative</a>, and <a href="https://developer.autodesk.com/en/docs/design-automation/v2/overview/" target="_blank">Design Automation</a>.

### Requirements
* Java version 7 and above.
* A registered app on the <a href="https://developer.autodesk.com/myapps" target="_blank">Forge Developer portal</a>.
* [Apache Maven](https://maven.apache.org/).

### Installation

Manually install all the JARs from the <a href="https://github.com/Autodesk-Forge/forge-api-java-client-jars" target="_blank">*forge-api-java-client-jars*</a> repo.

## Tutorial
Follow this tutorial to see a step-by-step authentication guide, and examples of how to use the Forge APIs.

### Create an App
Create an app on the Forge Developer portal. Note the client ID and client secret.

### Authentication
This SDK comes with an <a href="https://developer.autodesk.com/en/docs/oauth/v2/overview/" target="_blank">OAuth 2.0</a> client that allows you to retrieve 2-legged and 3-legged tokens. It also enables you to refresh 3-legged tokens. This tutorial uses both 2-legged and 3-legged tokens for calling different Data Management endpoints.


#### 2-Legged Token

This type of token is given directly to the application.
To get a 2-legged token run the following code:

``` Java
String CLIENT_ID = "" , CLIENT_SECRET = "";
List<String> scopes = new ArrayList<String>();
scopes.add("data:read");
scopes.add("data:write");

// Initialize the 2-legged OAuth 2.0 client, and optionally set specific scopes.
// If you omit scopes, the generated token will have all scope permissions.
OAuth2TwoLegged oauth2TwoLegged = new OAuth2TwoLegged(CLIENT_ID, CLIENT_SECRET, scopes, true);
Credentials twoLeggedCredentials = oauth2TwoLegged.authenticate();
```

#### 3-Legged Token
##### Generate an Authentication URL

To ask for permissions from a user to retrieve an access token, you
redirect the user to a consent page. Run this code to create a consent page URL:

``` Java
String CLIENT_ID = "" , CLIENT_SECRET = "", REDIRECT_URL = "";
// Generate a url that asks permissions for specific scopes.
List<String> scopes = new ArrayList<String>();
scopes.add("data:read");
scopes.add("data:write");

// Initialize the 3-legged OAuth 2.0 client, and optionally set specific scopes.
// If you omit scopes, the generated token will have all scope permissions.
OAuth2ThreeLegged oauth2ThreeLegged = new OAuth2ThreeLegged(CLIENT_ID, CLIENT_SECRET, REDIRECT_URL, scopes, true);

// Generate a URL page that asks for permissions for the specified scopes.
String oauthUrl = oauth2ThreeLegged.getAuthenticationUrl();

//Redirect the user to authUrl (the user consent page).
```

##### Retrieve an Authorization Code

Once a user receives permissions on the consent page, Forge will redirect
the page to the redirect URL you provided when you created the app. An authorization code is returned in the query string.

GET /callback?code={authorizationCode}

##### Retrieve an Access Token

Request an access token using the authorization code you received, as shown below:

``` Java
// The `threeLeggedCredentials` object contains an `access_token` and an optional `refresh_token` that you can use to call the endpoints.
ThreeLeggedCredentials threeLeggedCredentials = oauth2ThreeLegged.getAccessToken(authorizationCode);
```

Note that access tokens expire after a short period of time. The `expiresAt` field in the `threeLeggedCredentials` object gives the validity of an access token in seconds. To refresh your access token, call the `oauth2ThreeLegged.refreshAccessToken(threeLeggedCredentials.getRefreshToken());` method.


#### Example API Calls

Use the `threeLeggedCredentials` object to call the Forge APIs.

```java
// Import the libraries.
import com.autodesk.client.ApiException;
import com.autodesk.client.ApiResponse;
import com.autodesk.client.api.BucketsApi;
import com.autodesk.client.api.HubsApi;
import com.autodesk.client.auth.*;
import com.autodesk.client.model.*;
import java.util.ArrayList;
import java.util.List;

public class ForgeApiExample {

    public static void main(String[] args) {

        try {
            // Initialize the oauth2TwoLegged object using the client key and client secret you received when creating the app on the Forge Developer portal:
            OAuth2TwoLegged oauth2TwoLegged = new OAuth2TwoLegged("<CLIENT_ID>", "<CLIENT_SECRET>", scopes, true);
            Credentials twoLeggedCredentials = oauth2TwoLegged.authenticate();
                
            // Initialize the relevant clients; in this example, the Hubs and Buckets clients (part of the Data Management API).
            BucketsApi bucketsApi = new BucketsApi();
            HubsApi hubsApi = new HubsApi();

            // Get the buckets owned by an application.
            // Use the oauth2TwoLegged and twoLeggedCredentials objects that you retrieved previously.
            ApiResponse<Buckets> bucketsApiResponse = bucketsApi.getBuckets(null, null, null, oauth2TwoLegged, twoLeggedCredentials);
            System.out.println(bucketsApiResponse.getData());
            
            // Get the hubs that are accessible for a member.
            // Use the oauth2ThreeLegged and threeLeggedCredentials objects that you retrieved previously.
            ApiResponse<Hubs> hubsApiResponse = hubsApi.getHubs(null, null, oauth2ThreeLegged, threeLeggedCredentials);
            System.out.println(hubsApiResponse.getData());
            
        } catch (Exception e) {
            System.err.println("Exception when calling Forge APIs");
            e.printStackTrace();
        }
    }
}
```

## Support

forge.help@autodesk.com

