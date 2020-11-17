package com.autodesk.samples;

import com.autodesk.client.ApiException;
import com.autodesk.client.ApiResponse;
import com.autodesk.client.api.BucketsApi;
import com.autodesk.client.api.DerivativesApi;
import com.autodesk.client.api.ObjectsApi;
import com.autodesk.client.api.ProjectsApi;
import com.autodesk.client.auth.Credentials;
import com.autodesk.client.auth.OAuth2ThreeLegged;
import com.autodesk.client.auth.OAuth2TwoLegged;
import com.autodesk.client.auth.ThreeLeggedCredentials;
import com.autodesk.client.model.*;
import org.apache.commons.codec.binary.Base64;

import javax.ws.rs.core.UriBuilder;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//This sample will test end-points of Data Management API by 3 legged token

public class three_legged_dm{

    // TODO - insert your CLIENT_ID and CLIENT_SECRET, CALLBACK of Forge App
	private static final String CLIENT_ID = "<your forge client key>";
	private static final String CLIENT_SECRET = "<your forge client secret>";
    private static final String CALLBACK = "<your forge app call back url>";

    //use other tool to generate oAuth Code from the logged users
    //About 3 legged token workflow: 
    //https://forge.autodesk.com/en/docs/oauth/v2/tutorials/get-3-legged-token/
    private static final String OAUTH_CODE = "<oauth code>";


    // Initialize the relevant clients; 
    private static final  ProjectsApi oProjectApi = new ProjectsApi(); 
    private static OAuth2ThreeLegged oauthThreeLegged;
    private static ThreeLeggedCredentials threeLeggedCredentials;

    //can test with other regions such as emea
    //may be of use for some specific endpoints test
    private static String region = "us"; 

    /**
     * Initialize the 3-legged OAuth 2.0 client, and  set specific scopes.
     * 
     * @throws Exception
     */
    private static void initializeOAuth() throws Exception {

        // scopes are consistent to those when oauth code is generated.
        List<String> scopes = new ArrayList<String>();
        scopes.add("data:read");
        scopes.add("data:write");
        scopes.add("bucket:create");
        scopes.add("bucket:read");
        
        oauthThreeLegged =  new OAuth2ThreeLegged(CLIENT_ID,CLIENT_SECRET, CALLBACK,scopes, Boolean.valueOf(true));
        threeLeggedCredentials = oauthThreeLegged.authenticate(OAUTH_CODE);
    }
    
    /**
     * Example of get user at me data using Forge SDK. Uses the
     * oauthThreeLegged and threeLeggedCredentials objects that you retrieved
     * previously.
     * 
     * @throws           com.autodesk.client.ApiException
     * @throws Exception
     */
    
    private static void getUserAtMe() throws ApiException, Exception {
        System.out.println("***** Sending get user @ me request");
        
        ApiResponse<UserAtMe> oUserAtMeRes = oProjectApi.getUserAtMe(oauthThreeLegged, threeLeggedCredentials);
        UserAtMe oUserAtMe = oUserAtMeRes.getData(); 
        System.out.println(oUserAtMe.toString()); 
    }
 
    public static void main(String[] args) throws Exception {

        try { 
        	 initializeOAuth();

             //test GET:User@Me endpoint
        	 getUserAtMe();
             
        } catch (ApiException e) {
            System.err.println("Error Initializing OAuth client : " + e.toString());
        }
        
        
    }
}
