package com.autodesk.samples;

import com.autodesk.client.ApiException;
import com.autodesk.client.ApiResponse;
import com.autodesk.client.api.BucketsApi;
import com.autodesk.client.api.DerivativesApi;
import com.autodesk.client.api.ObjectsApi;
import com.autodesk.client.auth.Credentials;
import com.autodesk.client.auth.OAuth2TwoLegged;
import com.autodesk.client.model.*;
import org.apache.commons.codec.binary.Base64;

import javax.ws.rs.core.UriBuilder;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    //TODO - insert your CLIENT_ID and CLIENT_SECRET
    private static final String CLIENT_ID = "";
    private static final String CLIENT_SECRET = "";

    private static final String BUCKET_KEY = "forge-java-sample-app-" + CLIENT_ID.toLowerCase();

    private static final String FILE_NAME = "my-elephant.obj";
    private static final String FILE_PATH = "samples/com/autodesk/samples/elephant.obj";

    // Initialize the relevant clients; in this example, the Objects, Buckets and Derivatives clients, which are part of the Data Management API and Model Derivatives API
    private static final BucketsApi bucketsApi = new BucketsApi();
    private static final ObjectsApi objectsApi = new ObjectsApi();
    private static final DerivativesApi derivativesApi = new DerivativesApi();

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
     * Example of how to create a new bucket using Forge SDK.
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
     * Example of how to upload a file to the bucket.
     * Uses the oauth2TwoLegged and twoLeggedCredentials objects that you retrieved previously.
     * @throws java.io.FileNotFoundException
     * @throws com.autodesk.client.ApiException
     * @throws Exception
     */
    private static ObjectDetails uploadFile() throws FileNotFoundException, ApiException, Exception {
        System.out.println("***** Sending uploadFile request" );
        File fileToUpload = new File(FILE_PATH);
        ApiResponse<ObjectDetails> response = objectsApi.uploadObject(BUCKET_KEY, FILE_NAME, (int)fileToUpload.length(), fileToUpload, null, null, oauth2TwoLegged, twoLeggedCredentials);

        System.out.println("***** Response for uploadFile: ");
        ObjectDetails objectDetails = response.getData();
        System.out.println("Uploaded object Details - Location: " + objectDetails.getLocation() + ", Size:"+objectDetails.getSize());
        return objectDetails;
    }

    /**
     * Example of how to send a translate to SVF job request.
     * Uses the oauth2TwoLegged and twoLeggedCredentials objects that you retrieved previously.
     * @param urn - the urn of the file to translate
     * @throws com.autodesk.client.ApiException
     * @throws Exception
     */
    private static Job translateToSVF(String urn) throws ApiException, Exception{
        System.out.println("***** Sending Derivative API translate request" );

        JobPayload job = new JobPayload();

        byte[] urnBase64 = Base64.encodeBase64(urn.getBytes());

        JobPayloadInput input = new JobPayloadInput();
        input.setUrn(new String(urnBase64));

        JobPayloadOutput output = new JobPayloadOutput();
        JobPayloadItem formats = new JobPayloadItem();
        formats.setType(JobPayloadItem.TypeEnum.SVF);
        formats.setViews(Arrays.asList(JobPayloadItem.ViewsEnum._3D));
        output.setFormats(Arrays.asList(formats));

        job.setInput(input);
        job.setOutput(output);

        ApiResponse<Job> response = derivativesApi.translate(job,true,oauth2TwoLegged,twoLeggedCredentials);
        System.out.println("***** Response for Translating File to SVF: " + response.getData());

        return response.getData();
    }

    /**
     * Example of how to query the status of a translate job.
     * Uses the oauth2TwoLegged and twoLeggedCredentials objects that you retrieved previously.
     * @param base64Urn - the urn of the file to translate in base 64 format
     * @throws com.autodesk.client.ApiException
     * @throws Exception
     */
    private static Manifest verifyJobComplete(String base64Urn) throws ApiException, Exception{
        System.out.println("***** Sending getManifest request" );
        boolean isComplete = false;
        ApiResponse<Manifest> response = null;

        while(!isComplete){
            response = derivativesApi.getManifest(base64Urn,null,oauth2TwoLegged,twoLeggedCredentials);
            Manifest manifest = response.getData();
            if(response.getData().getProgress().equals("complete")){
                isComplete = true;
                System.out.println("***** Finished translating your file to SVF - status: " + manifest.getStatus() + ", progress:" + manifest.getProgress());
            }
            else{
                System.out.println("***** Haven't finished translating your file to SVF - status: " + manifest.getStatus() + ", progress:" + manifest.getProgress());
                Thread.sleep(1000);
            }
        }

        return response.getData();

    }

    /**
     * Open translated SVF file in the viewer
     * Uses the twoLeggedCredentials object that you retrieved previously.
     * Opens the file statically from your hard drive with url parameters for the accessToken and for the urn of the file to show.
     * @param base64Urn
     * @throws IOException
     */
    private static void openViewer(String base64Urn) throws IOException {
        System.out.println("***** Opening SVF file in viewer with urn:" + base64Urn);
        File htmlFile = new File("samples/com/autodesk/samples/viewer.html");
        UriBuilder builder = UriBuilder.fromPath("file:///" + htmlFile.getAbsolutePath()).queryParam("token",twoLeggedCredentials.getAccessToken()).queryParam("urn",base64Urn);
        Desktop.getDesktop().browse(builder.build());
    }

    /**
     * Example of how to delete a file that was uploaded by the application.
     * Uses the oauth2TwoLegged and twoLeggedCredentials objects that you retrieved previously.
     * @throws com.autodesk.client.ApiException
     * @throws Exception
     */
    private static void deleteFile() throws ApiException, Exception{
        System.out.println("***** Sending deleteFile request" );
        ApiResponse<Void> response = objectsApi.deleteObject(BUCKET_KEY, FILE_NAME, oauth2TwoLegged, twoLeggedCredentials);
        System.out.println("***** Response Code for deleting File: " + response.getStatusCode());
    }

    public static void main(String[] args) throws Exception {

        try{
            initializeOAuth();

            try{
                createBucket();
            }
            catch (ApiException e){
                System.err.println("Error creating bucket : " + e.getResponseBody());
            }

            try{
                ObjectDetails uploadedObject = uploadFile();

                try{
                    Job job = translateToSVF(uploadedObject.getObjectId());

                    if(job.getResult().equals("success")){
                        String base64Urn = job.getUrn();

                        Manifest manifest = verifyJobComplete(base64Urn);
                        if (manifest.getStatus().equals("success")){
                            openViewer(manifest.getUrn());
                        }
                    }
                }
                catch (ApiException e){
                    System.err.println("Error translating file : " + e.getResponseBody());
                }

            }
            catch (ApiException e){
                System.err.println("Error uploading file : " + e.getResponseBody());
            }
        }
        catch (ApiException e){
            System.err.println("Error Initializing OAuth client : " + e.getResponseBody());
        }
    }
}
