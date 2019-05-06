# Forge Java SDK

*Forge API*:
[![oAuth2](https://img.shields.io/badge/oAuth2-v1-green.svg)](http://autodesk-forge.github.io/)
[![Data-Management](https://img.shields.io/badge/Data%20Management-v1-green.svg)](http://autodesk-forge.github.io/)
[![OSS](https://img.shields.io/badge/OSS-v2-green.svg)](http://autodesk-forge.github.io/)
[![Model-Derivative](https://img.shields.io/badge/Model%20Derivative-v2-green.svg)](http://autodesk-forge.github.io/)
[![Build Status](https://travis-ci.org/dukedhx/forge-api-java-client.svg?branch=master)](https://travis-ci.org/dukedhx/forge-api-java-client)

## Overview
This [Java](https://java.com/) SDK enables you to easily integrate the Forge REST APIs into your application,
including <a href="https://developer.autodesk.com/en/docs/oauth/v2/overview/" target="_blank">OAuth</a>, <a href="https://developer.autodesk.com/en/docs/data/v2/overview/" target="_blank">Data Management</a>, <a href="https://developer.autodesk.com/en/docs/model-derivative/v2/overview/" target="_blank">Model Derivative</a>, and <a href="https://developer.autodesk.com/en/docs/design-automation/v2/overview/" target="_blank">Design Automation</a>.

### Requirements
* Java version 7 and above.
* A registered app on the <a href="https://developer.autodesk.com/myapps" target="_blank">Forge Developer portal</a>.
* [Apache Maven](https://maven.apache.org/).

### Install the Library

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

#### Maven users
Add the following dependency to your `pom.xml`:

```xml
<dependency>
   	<groupId>com.autodesk</groupId>
   	<artifactId>forge-java-sdk</artifactId>
   	<version>1.0.2</version>
</dependency>
```

#### Gradle users

Add this dependency to your project's build file:

```groovy
repositories {
    mavenLocal()
}
dependencies {
    compile "com.autodesk:com-autodesk-client:1.0.2"
}
```

## Tutorial
Follow this tutorial to see a step-by-step process and examples of how to use the Forge APIs.

[Learn Forge](https://learnforge.autodesk.io/)

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
// Set autoRefresh to `true` to automatically refresh the access token when it expires.
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
// Set autoRefresh to `true` to automatically refresh the access token when it expires.
// Note that the REDIRECT_URL must match the callback URL you provided when you created the app.
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
            List<String> scopes = new ArrayList<String>();
            scopes.add("data:read");
            scopes.add("data:write");
            scopes.add("bucket:create");
            scopes.add("bucket:read");

            // Initialize the oauth2TwoLegged object using the client key and client secret you received when creating the app on the Forge Developer portal:
            OAuth2TwoLegged oauth2TwoLegged = new OAuth2TwoLegged("<CLIENT_ID>", "<CLIENT_SECRET>", scopes, true);
            Credentials twoLeggedCredentials = oauth2TwoLegged.authenticate();

            // Initialize the relevant clients; in this example, the Hubs and Buckets clients (part of the Data Management API).
            BucketsApi bucketsApi = new BucketsApi();
            HubsApi hubsApi = new HubsApi();

            // Create a new bucket
            // Use the oauth2TwoLegged and twoLeggedCredentials objects that you retrieved previously.
            PostBucketsPayload payload = new PostBucketsPayload();
            payload.setBucketKey("test_bucket_key");
            payload.setPolicyKey(PostBucketsPayload.PolicyKeyEnum.PERSISTENT);
            ApiResponse<Bucket> createBucketResponse = bucketsApi.createBucket(payload, "", oauth2TwoLegged, twoLeggedCredentials);
            System.out.println(createBucketResponse.getData().getBucketKey());

            // Get the buckets owned by an application.
            // Use the oauth2TwoLegged and twoLeggedCredentials objects that you retrieved previously.
            ApiResponse<Buckets> getBucketsResponse = bucketsApi.getBuckets(null, null, null, oauth2TwoLegged, twoLeggedCredentials);
            for(BucketsItems bucket: getBucketsResponse.getData().getItems()) {
                System.out.println(bucket.getBucketKey());
            }

            // Get the hubs that are accessible for a member.
            // Use the oauth2ThreeLegged and threeLeggedCredentials objects that you retrieved previously.
            ApiResponse<Hubs> getHubsResponse = hubsApi.getHubs(null, null, oauth2ThreeLegged, threeLeggedCredentials);
            for(Hub hub: getHubsResponse.getData().getData()) {
                System.out.println(hub.getId());
            }

        } catch (Exception e) {
            System.err.println("Exception when calling Forge APIs");
            e.printStackTrace();
        }
    }
}
```

## API Documentation

You can get the full documentation for the API on the [Developer Portal](https://developer.autodesk.com/)

### Documentation for API Endpoints

All URIs are relative to https://developer.api.autodesk.com/ (for example createBucket URI is 'https://developer.api.autodesk.com/oss/v2/buckets')


Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*ActivitiesApi* | [**createActivity**](docs/ActivitiesApi.md#createActivity) | **POST** /autocad.io/us-east/v2/Activities | Creates a new Activity.
*ActivitiesApi* | [**deleteActivity**](docs/ActivitiesApi.md#deleteActivity) | **DELETE** /autocad.io/us-east/v2/Activities(&#39;{id}&#39;) | Removes a specific Activity.
*ActivitiesApi* | [**deleteActivityHistory**](docs/ActivitiesApi.md#deleteActivityHistory) | **POST** /autocad.io/us-east/v2/Activities(&#39;{id}&#39;)/Operations.DeleteHistory | Removes the version history of the specified Activity.
*ActivitiesApi* | [**getActivity**](docs/ActivitiesApi.md#getActivity) | **GET** /autocad.io/us-east/v2/Activities(&#39;{id}&#39;) | Returns the details of a specific Activity.
*ActivitiesApi* | [**getActivityVersions**](docs/ActivitiesApi.md#getActivityVersions) | **GET** /autocad.io/us-east/v2/Activities(&#39;{id}&#39;)/Operations.GetVersions | Returns all old versions of a specified Activity.
*ActivitiesApi* | [**getAllActivities**](docs/ActivitiesApi.md#getAllActivities) | **GET** /autocad.io/us-east/v2/Activities | Returns the details of all Activities.
*ActivitiesApi* | [**patchActivity**](docs/ActivitiesApi.md#patchActivity) | **PATCH** /autocad.io/us-east/v2/Activities(&#39;{id}&#39;) | Updates an Activity by specifying only the changed attributes.
*ActivitiesApi* | [**setActivityVersion**](docs/ActivitiesApi.md#setActivityVersion) | **POST** /autocad.io/us-east/v2/Activities(&#39;{id}&#39;)/Operations.SetVersion | Sets the Activity to the specified version.
*ActivitiesApi* | [**updateActivity**](docs/ActivitiesApi.md#updateActivity) | **PUT** /autocad.io/us-east/v2/Activities(&#39;{id}&#39;) | Updates an Activity by redefining the entire Activity object.
*AppPackagesApi* | [**createAppPackage**](docs/AppPackagesApi.md#createAppPackage) | **POST** /autocad.io/us-east/v2/AppPackages | Creates an AppPackage module.
*AppPackagesApi* | [**deleteAppPackage**](docs/AppPackagesApi.md#deleteAppPackage) | **DELETE** /autocad.io/us-east/v2/AppPackages(&#39;{id}&#39;) | Removes a specific AppPackage.
*AppPackagesApi* | [**deleteAppPackageHistory**](docs/AppPackagesApi.md#deleteAppPackageHistory) | **POST** /autocad.io/us-east/v2/AppPackages(&#39;{id}&#39;)/Operations.DeleteHistory | Removes the version history of the specified AppPackage.
*AppPackagesApi* | [**getAllAppPackages**](docs/AppPackagesApi.md#getAllAppPackages) | **GET** /autocad.io/us-east/v2/AppPackages | Returns the details of all AppPackages.
*AppPackagesApi* | [**getAppPackage**](docs/AppPackagesApi.md#getAppPackage) | **GET** /autocad.io/us-east/v2/AppPackages(&#39;{id}&#39;) | Returns the details of a specific AppPackage.
*AppPackagesApi* | [**getAppPackageVersions**](docs/AppPackagesApi.md#getAppPackageVersions) | **GET** /autocad.io/us-east/v2/AppPackages(&#39;{id}&#39;)/Operations.GetVersions | Returns all old versions of a specified AppPackage.
*AppPackagesApi* | [**getUploadUrl**](docs/AppPackagesApi.md#getUploadUrl) | **GET** /autocad.io/us-east/v2/AppPackages/Operations.GetUploadUrl | Requests a pre-signed URL for uploading a zip file that contains the binaries for this AppPackage.
*AppPackagesApi* | [**getUploadUrlWithRequireContentType**](docs/AppPackagesApi.md#getUploadUrlWithRequireContentType) | **GET** /autocad.io/us-east/v2/AppPackage/Operations.GetUploadUrl(RequireContentType&#x3D;{require}) | Requests a pre-signed URL for uploading a zip file that contains the binaries for this AppPackage. Unlike the GetUploadUrl method that takes no parameters, this method allows the client to request that the pre-signed URL to be issued so that the subsequent HTTP PUT operation will require Content-Type&#x3D;binary/octet-stream.
*AppPackagesApi* | [**patchAppPackage**](docs/AppPackagesApi.md#patchAppPackage) | **PATCH** /autocad.io/us-east/v2/AppPackages(&#39;{id}&#39;) | Updates an AppPackage by specifying only the changed attributes.
*AppPackagesApi* | [**setAppPackageVersion**](docs/AppPackagesApi.md#setAppPackageVersion) | **POST** /autocad.io/us-east/v2/AppPackages(&#39;{id}&#39;)/Operations.SetVersion | Sets the AppPackage to the specified version.
*AppPackagesApi* | [**updateAppPackage**](docs/AppPackagesApi.md#updateAppPackage) | **PUT** /autocad.io/us-east/v2/AppPackages(&#39;{id}&#39;) | Updates an AppPackage by redefining the entire Activity object.
*BucketsApi* | [**createBucket**](docs/BucketsApi.md#createBucket) | **POST** /oss/v2/buckets |
*BucketsApi* | [**deleteBucket**](docs/BucketsApi.md#deleteBucket) | **DELETE** /oss/v2/buckets/{bucketKey} |
*BucketsApi* | [**getBucketDetails**](docs/BucketsApi.md#getBucketDetails) | **GET** /oss/v2/buckets/{bucketKey}/details |
*BucketsApi* | [**getBuckets**](docs/BucketsApi.md#getBuckets) | **GET** /oss/v2/buckets |
*DerivativesApi* | [**deleteManifest**](docs/DerivativesApi.md#deleteManifest) | **DELETE** /modelderivative/v2/designdata/{urn}/manifest |
*DerivativesApi* | [**getDerivativeManifest**](docs/DerivativesApi.md#getDerivativeManifest) | **GET** /modelderivative/v2/designdata/{urn}/manifest/{derivativeUrn} |
*DerivativesApi* | [**getFormats**](docs/DerivativesApi.md#getFormats) | **GET** /modelderivative/v2/designdata/formats |
*DerivativesApi* | [**getManifest**](docs/DerivativesApi.md#getManifest) | **GET** /modelderivative/v2/designdata/{urn}/manifest |
*DerivativesApi* | [**getMetadata**](docs/DerivativesApi.md#getMetadata) | **GET** /modelderivative/v2/designdata/{urn}/metadata |
*DerivativesApi* | [**getModelviewMetadata**](docs/DerivativesApi.md#getModelviewMetadata) | **GET** /modelderivative/v2/designdata/{urn}/metadata/{guid} |
*DerivativesApi* | [**getModelviewProperties**](docs/DerivativesApi.md#getModelviewProperties) | **GET** /modelderivative/v2/designdata/{urn}/metadata/{guid}/properties |
*DerivativesApi* | [**getThumbnail**](docs/DerivativesApi.md#getThumbnail) | **GET** /modelderivative/v2/designdata/{urn}/thumbnail |
*DerivativesApi* | [**translate**](docs/DerivativesApi.md#translate) | **POST** /modelderivative/v2/designdata/job |
*EnginesApi* | [**getAllEngines**](docs/EnginesApi.md#getAllEngines) | **GET** /autocad.io/us-east/v2/Engines | Returns the details of all available AutoCAD core engines.
*EnginesApi* | [**getEngine**](docs/EnginesApi.md#getEngine) | **GET** /autocad.io/us-east/v2/Engines(&#39;{id}&#39;) | Returns the details of a specific AutoCAD core engine.
*FoldersApi* | [**getFolder**](docs/FoldersApi.md#getFolder) | **GET** /data/v1/projects/{project_id}/folders/{folder_id} |
*FoldersApi* | [**getFolderContents**](docs/FoldersApi.md#getFolderContents) | **GET** /data/v1/projects/{project_id}/folders/{folder_id}/contents |
*FoldersApi* | [**getFolderParent**](docs/FoldersApi.md#getFolderParent) | **GET** /data/v1/projects/{project_id}/folders/{folder_id}/parent |
*FoldersApi* | [**getFolderRefs**](docs/FoldersApi.md#getFolderRefs) | **GET** /data/v1/projects/{project_id}/folders/{folder_id}/refs |
*FoldersApi* | [**getFolderRelationshipsRefs**](docs/FoldersApi.md#getFolderRelationshipsRefs) | **GET** /data/v1/projects/{project_id}/folders/{folder_id}/relationships/refs |
*FoldersApi* | [**postFolderRelationshipsRef**](docs/FoldersApi.md#postFolderRelationshipsRef) | **POST** /data/v1/projects/{project_id}/folders/{folder_id}/relationships/refs |
*HubsApi* | [**getHub**](docs/HubsApi.md#getHub) | **GET** /project/v1/hubs/{hub_id} |
*HubsApi* | [**getHubs**](docs/HubsApi.md#getHubs) | **GET** /project/v1/hubs |
*ItemsApi* | [**getItem**](docs/ItemsApi.md#getItem) | **GET** /data/v1/projects/{project_id}/items/{item_id} |
*ItemsApi* | [**getItemParentFolder**](docs/ItemsApi.md#getItemParentFolder) | **GET** /data/v1/projects/{project_id}/items/{item_id}/parent |
*ItemsApi* | [**getItemRefs**](docs/ItemsApi.md#getItemRefs) | **GET** /data/v1/projects/{project_id}/items/{item_id}/refs |
*ItemsApi* | [**getItemRelationshipsRefs**](docs/ItemsApi.md#getItemRelationshipsRefs) | **GET** /data/v1/projects/{project_id}/items/{item_id}/relationships/refs |
*ItemsApi* | [**getItemTip**](docs/ItemsApi.md#getItemTip) | **GET** /data/v1/projects/{project_id}/items/{item_id}/tip |
*ItemsApi* | [**getItemVersions**](docs/ItemsApi.md#getItemVersions) | **GET** /data/v1/projects/{project_id}/items/{item_id}/versions |
*ItemsApi* | [**postItemRelationshipsRef**](docs/ItemsApi.md#postItemRelationshipsRef) | **POST** /data/v1/projects/{project_id}/items/{item_id}/relationships/refs |
*ItemsApi* | [**postItem**](docs/ItemsApi.md#postItem) | **POST** /data/v1/projects/{project_id}/items |
*ObjectsApi* | [**copyTo**](docs/ObjectsApi.md#copyTo) | **PUT** /oss/v2/buckets/{bucketKey}/objects/{objectName}/copyTo/{newObjName} |
*ObjectsApi* | [**createSignedResource**](docs/ObjectsApi.md#createSignedResource) | **POST** /oss/v2/buckets/{bucketKey}/objects/{objectName}/signed |
*ObjectsApi* | [**deleteObject**](docs/ObjectsApi.md#deleteObject) | **DELETE** /oss/v2/buckets/{bucketKey}/objects/{objectName} |
*ObjectsApi* | [**deleteSignedResource**](docs/ObjectsApi.md#deleteSignedResource) | **DELETE** /oss/v2/signedresources/{id} |
*ObjectsApi* | [**getObject**](docs/ObjectsApi.md#getObject) | **GET** /oss/v2/buckets/{bucketKey}/objects/{objectName} |
*ObjectsApi* | [**getObjectDetails**](docs/ObjectsApi.md#getObjectDetails) | **GET** /oss/v2/buckets/{bucketKey}/objects/{objectName}/details |
*ObjectsApi* | [**getObjects**](docs/ObjectsApi.md#getObjects) | **GET** /oss/v2/buckets/{bucketKey}/objects |
*ObjectsApi* | [**getStatusBySessionId**](docs/ObjectsApi.md#getStatusBySessionId) | **GET** /oss/v2/buckets/{bucketKey}/objects/{objectName}/status/{sessionId} |
*ObjectsApi* | [**getSignedResource**](docs/ObjectsApi.md#getSignedResource) | **GET** /oss/v2/signedresources/{id} |
*ObjectsApi* | [**uploadChunk**](docs/ObjectsApi.md#uploadChunk) | **PUT** /oss/v2/buckets/{bucketKey}/objects/{objectName}/resumable |
*ObjectsApi* | [**uploadObject**](docs/ObjectsApi.md#uploadObject) | **PUT** /oss/v2/buckets/{bucketKey}/objects/{objectName} |
*ObjectsApi* | [**uploadSignedResource**](docs/ObjectsApi.md#uploadSignedResource) | **PUT** /oss/v2/signedresources/{id} |
*ObjectsApi* | [**uploadSignedResourcesChunk**](docs/ObjectsApi.md#uploadSignedResourcesChunk) | **PUT** /oss/v2/signedresources/{id}/resumable |
*ProjectsApi* | [**getProject**](docs/ProjectsApi.md#getProject) | **GET** /project/v1/hubs/{hub_id}/projects/{project_id} |
*ProjectsApi* | [**getProjectHub**](docs/ProjectsApi.md#getProjectHub) | **GET** /project/v1/hubs/{hub_id}/projects/{project_id}/hub |
*ProjectsApi* | [**postStorage**](docs/ProjectsApi.md#postStorage) | **POST** /data/v1/projects/{project_id}/storage |
*ProjectsApi* | [**postVersion**](docs/ProjectsApi.md#postVersion) | **POST** /data/v1/projects/{project_id}/versions |
*ProjectsApi* | [**getHubProjects**](docs/ProjectsApi.md#getHubProjects) | **GET** /project/v1/hubs/{hub_id}/projects |
*VersionsApi* | [**getVersion**](docs/VersionsApi.md#getVersion) | **GET** /data/v1/projects/{project_id}/versions/{version_id} |
*VersionsApi* | [**getVersionItem**](docs/VersionsApi.md#getVersionItem) | **GET** /data/v1/projects/{project_id}/versions/{version_id}/item |
*VersionsApi* | [**getVersionRefs**](docs/VersionsApi.md#getVersionRefs) | **GET** /data/v1/projects/{project_id}/versions/{version_id}/refs |
*VersionsApi* | [**getVersionRelationshipsRefs**](docs/VersionsApi.md#getVersionRelationshipsRefs) | **GET** /data/v1/projects/{project_id}/versions/{version_id}/relationships/refs |
*VersionsApi* | [**postVersionRelationshipsRef**](docs/VersionsApi.md#postVersionRelationshipsRef) | **POST** /data/v1/projects/{project_id}/versions/{version_id}/relationships/refs |
*WorkItemsApi* | [**createWorkItem**](docs/WorkItemsApi.md#createWorkItem) | **POST** /autocad.io/us-east/v2/WorkItems | Creates a new WorkItem.
*WorkItemsApi* | [**deleteWorkItem**](docs/WorkItemsApi.md#deleteWorkItem) | **DELETE** /autocad.io/us-east/v2/WorkItems(&#39;{id}&#39;) | Removes a specific WorkItem.
*WorkItemsApi* | [**getAllWorkItems**](docs/WorkItemsApi.md#getAllWorkItems) | **GET** /autocad.io/us-east/v2/WorkItems | Returns the details of all WorkItems.
*WorkItemsApi* | [**getWorkItem**](docs/WorkItemsApi.md#getWorkItem) | **GET** /autocad.io/us-east/v2/WorkItems(&#39;{id}&#39;) | Returns the details of a specific WorkItem.


### Thumbnail

![thumbnail](/thumbnail.png)

## Support

forge.help@autodesk.com
