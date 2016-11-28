package com.autodesk.samples;

import com.autodesk.client.ApiException;
import com.autodesk.client.ApiResponse;
import com.autodesk.client.api.BucketsApi;
import com.autodesk.client.api.ObjectsApi;
import com.autodesk.client.auth.Credentials;
import com.autodesk.client.auth.OAuth2TwoLegged;
import com.autodesk.client.model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {


    //TODO - insert your CLIENT_ID, CLIENT_SECRET
    private static final String CLIENT_ID = "";
    private static final String CLIENT_SECRET = "";

    //TODO - choose a bucket key
    private static final String BUCKET_KEY = "my-chosen-bucket-key";

    //TODO - choose a file to upload
    private static final String FILE_NAME = "UploadedFileName";
    private static final String FILE_PATH = "/path/to/file";

    // Initialize the relevant clients; in this example, the Hubs and Buckets clients (part of the Data Management API).
    private static final BucketsApi bucketsApi = new BucketsApi();
    private static final ObjectsApi objectsApi = new ObjectsApi();

    private static OAuth2TwoLegged oauth2TwoLegged;
    private static Credentials twoLeggedCredentials;

    /**
     * Initialize the 2-legged OAuth 2.0 client, and optionally set specific scopes.
     * @throws Exception
     */
    private static void initializeOAuth() throws Exception {

        // You must provide at least one valid scope
        List<String> scopes = new ArrayList<String>();
        scopes.add("data:read");
        scopes.add("data:write");
        scopes.add("bucket:create");
        scopes.add("bucket:read");

        //Set autoRefresh to `true` to automatically refresh the access token when it expires.
        oauth2TwoLegged = new OAuth2TwoLegged(CLIENT_ID, CLIENT_SECRET, scopes, true);
        twoLeggedCredentials = oauth2TwoLegged.authenticate();
    }

    /**
     * Create a new bucket.
     * Uses the oauth2TwoLegged and twoLeggedCredentials objects that you retrieved previously.
     * @throws com.autodesk.client.ApiException
     * @throws Exception
     */
    private static void createBucket() throws ApiException, Exception {
        System.out.println("***** Sending createBucket request" );
        PostBucketsPayload payload = new PostBucketsPayload();
        payload.setBucketKey(BUCKET_KEY);
        payload.setPolicyKey(PostBucketsPayload.PolicyKeyEnum.PERSISTENT);
        ApiResponse<Bucket> response = bucketsApi.createBucket(payload, "US", oauth2TwoLegged, twoLeggedCredentials);
        System.out.println("***** Response for createBucket: " + response.getData());
    }

    /**
     * Upload a File to previously created bucket.
     * Uses the oauth2TwoLegged and twoLeggedCredentials objects that you retrieved previously.
     * @throws java.io.FileNotFoundException
     * @throws com.autodesk.client.ApiException
     * @throws Exception
     */
    private static void uploadFile() throws FileNotFoundException, ApiException, Exception {
        System.out.println("***** Sending uploadFile request" );
        File fileToUpload = new File(FILE_PATH);
        ApiResponse<ObjectDetails> response = objectsApi.uploadObject(BUCKET_KEY, FILE_NAME, (int)fileToUpload.length(), fileToUpload, "txt", null, oauth2TwoLegged, twoLeggedCredentials);

        System.out.println("***** Response for uploadFile: ");
        ObjectDetails objectDetails = response.getData();
        System.out.println("Uploaded object Details - Location: " + objectDetails.getLocation() + ", Size:"+objectDetails.getSize());


    }

    /**
     * Get the buckets owned by an application.
     * Uses the oauth2TwoLegged and twoLeggedCredentials objects that you retrieved previously.
     * @throws com.autodesk.client.ApiException
     * @throws Exception
     */
    private static void getBuckets() throws ApiException, Exception{
        System.out.println("***** Sending getBuckets request" );
        ApiResponse<Buckets> getBucketsResponse = bucketsApi.getBuckets("US", null, null, oauth2TwoLegged, twoLeggedCredentials);

        System.out.println("***** Response for getBuckets: ");
        List<BucketsItems> buckets = getBucketsResponse.getData().getItems();
        for (BucketsItems bucket : buckets) {
            System.out.println("bucket key:" + bucket.getBucketKey() + ", createdDate:" +bucket.getCreatedDate());
        }
    }

    /**
     * Delete the file uploaded by the application.
     * Uses the oauth2TwoLegged and twoLeggedCredentials objects that you retrieved previously.
     * @throws com.autodesk.client.ApiException
     * @throws Exception
     */
    private static void deleteFile() throws ApiException, Exception{
        System.out.println("***** Sending deleteFile request" );
        ApiResponse<Void> response = objectsApi.deleteObject(BUCKET_KEY,FILE_NAME,oauth2TwoLegged,twoLeggedCredentials);
        System.out.println("***** Response Code for deleting File: " + response.getStatusCode());
    }

    public static void main(String[] args) throws Exception {

        try{
            initializeOAuth();
        }
        catch (ApiException e){
            System.err.println("Error Initializing OAuth client : " + e.getResponseBody());
        }

        try{
            createBucket();
        }
        catch (ApiException e){
            System.err.println("Error creating bucket : " + e.getResponseBody());
        }

        try{
            uploadFile();
        }
        catch (ApiException e){
            System.err.println("Error uploading file : " + e.getResponseBody());
        }

        try{
            getBuckets();
        }
        catch (ApiException e){
            System.err.println("Error getting buckets : " + e.getResponseBody());
        }

        try{
            deleteFile();
        }
        catch (ApiException e){
            System.err.println("Error deleting file : " + e.getResponseBody());
        }
    }

}

