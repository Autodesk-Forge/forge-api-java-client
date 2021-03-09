package com.autodesk.samples;

import com.autodesk.client.ApiException;
import com.autodesk.client.ApiResponse;
import com.autodesk.client.api.BucketsApi;
import com.autodesk.client.api.DerivativesApi;
import com.autodesk.client.api.HubsApi;
import com.autodesk.client.api.ItemsApi;
import com.autodesk.client.api.ObjectsApi;
import com.autodesk.client.api.ProjectsApi;
import com.autodesk.client.api.VersionsApi;
import com.autodesk.client.api.FoldersApi;

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

//This sample will test end-points of Data Management API of BIM 360 by 2 legged token

public class two_legged_bim360_dm{

    // TODO - insert your CLIENT_ID and CLIENT_SECRET
	 private static final String CLIENT_ID = "<your forge client key>";
	 private static final String CLIENT_SECRET = "<your forge client secret>";
	 
	 //input the names of the objects to inspect
	 private static final String BIM_ACCOUNT_NAME = "<your BIM account name>"; //e.g. Autodesk Forge Partner Development
	 private static final String BIM_PROJECT_NAME = "<your BIM project name>"; // e.g. Forge Concert Hall
	 private static final String BIM_FOLDER_NAME = "<folder name>";//e.g.Project Files
	 private static final String BIM_ITEM_NAME = "<file name in this folder>"; //e.g. rst_advanced_sample_project.rvt


    //backup for future test
    //private static final String BUCKET_KEY = "forge-java-sample-app-" + CLIENT_ID.toLowerCase();

    //private static final String FILE_NAME = "my-elephant.obj";
    //private static final String FILE_PATH = "samples/com/autodesk/samples/elephant.obj";
 
    //private static final BucketsApi bucketsApi = new BucketsApi();
    //private static final ObjectsApi objectsApi = new ObjectsApi();
    //private static final DerivativesApi derivativesApi = new DerivativesApi();
    
    // Initialize the relevant clients;     
    private static final  HubsApi oHubsApi = new HubsApi(); 
    private static final  ProjectsApi oProjecstApi = new ProjectsApi(); 
    private static final  FoldersApi oFoldersApi = new FoldersApi(); 
    private static final  ItemsApi oItemsApi = new ItemsApi(); 
    private static final  VersionsApi oVersionsApi = new VersionsApi(); 


    private static OAuth2TwoLegged oauth2TwoLegged;
    private static Credentials twoLeggedCredentials;
    
    private static String region = "us"; //can test with other regions such as emea

    /**
     * Initialize the 2-legged OAuth 2.0 client, and optionally set specific scopes.
     * 
     * @throws Exception
     */
    private static void initializeOAuth() throws Exception {

        // You must provide at least one valid scope
        List<String> scopes = new ArrayList<String>();
        scopes.add("data:read");
        scopes.add("data:write");
        scopes.add("bucket:create");
        scopes.add("bucket:read");

        // Set autoRefresh to `true` to automatically refresh the access token when it
        // expires.
        oauth2TwoLegged = new OAuth2TwoLegged(CLIENT_ID, CLIENT_SECRET, scopes, true);
        twoLeggedCredentials = oauth2TwoLegged.authenticate();
    }

     
    private static Hubs getHubs() throws  ApiException, Exception {
    	
        System.out.println("***** Sending get hubs request");
        ApiResponse<Hubs> response =oHubsApi.getHubs(null,null,oauth2TwoLegged,twoLeggedCredentials);

        System.out.println("***** Response for getHubs: ");
        Hubs hubs = response.getData();
        System.out.println("Hubs Count: " +hubs.getData().size());
        
        return hubs;
    }
    
    private static Projects getProjects(String hubId) throws  ApiException, Exception {
    	//get first page (limit =200)

    	System.out.println("***** Sending get projects request");
        ApiResponse<Projects> response =oProjecstApi.getHubProjects(hubId,null,null,0,200,oauth2TwoLegged,twoLeggedCredentials);

        System.out.println("***** Response for getProjects: ");
        Projects projects = response.getData();
        System.out.println("Projects Count: " +projects.getData().size());
       
        return projects;
    }
    
    private static Folders getTopFolders(String hubId,String projectId) throws  ApiException, Exception {

    	System.out.println("***** Sending get top folders request");
        ApiResponse<Folders> response =oProjecstApi.topFolders(hubId,projectId,oauth2TwoLegged,twoLeggedCredentials);

        System.out.println("***** Response for getTopFolders: ");
        Folders folders = response.getData();
        System.out.println("Folder Count: " +folders.getData().size());
       
        return folders;
    }
    
    private static Folder getFolder(String projectId,String folderId) throws  ApiException, Exception {

    	System.out.println("***** Sending get one folder request");
        ApiResponse<Folder> response = oFoldersApi.getFolder(projectId,folderId,oauth2TwoLegged,twoLeggedCredentials);

        System.out.println("***** Response for get one folder: ");
        Folder folder = response.getData();
        JsonApiResource jsonData = folder.getData();
        JsonApiAttributes folderAtt = jsonData.getAttributes();
        //print some data you are interested in.
        System.out.println("One BIM360 Folder: <id>: " + jsonData.getId() +
        					" \n<name>:" + folderAtt.getName() +
        					" \n<createTime>:" + folderAtt.getCreateTime().toString()+
        					" \n<createUserName>:" + folderAtt.getCreateUserName().toString()+
        					" \n<objectCount>" + folderAtt.getObjectCount().toString() +
        					" \n<extension type>" + folderAtt.getExtension().getType() 
 
        					);
        
       
        return folder;
    }
    

     
    public static void main(String[] args) throws Exception {

        try {
            	initializeOAuth(); 
            	
                Hubs hubs = getHubs();
                if(hubs.getData().size() ==0 )
                    throw new Exception("hubs size ==0 ");

            	//print one hub info 
            	//assume the  hub is what we want to test
                	
                Hub hub = hubs.getData().stream()
                      	  .filter(f -> BIM_ACCOUNT_NAME.equals(f.getAttributes().getName()))
                      	  .findAny()
                      	  .orElse(null);  
                System.out.println("One BIM360 Hub: <id>: " + hub.getId() + " <name>:" + hub.getAttributes().getName() ); 
                    
                    String hubId = hub.getId(); 
                    Projects projects = getProjects(hubId);
                    if(projects.getData().size() ==0 )
                        throw new Exception("projects size ==0 ");
                    	//print one project info
                    	//assume the  project is what we want to test
                    	Project project = projects.getData().stream()
                      	  .filter(f -> BIM_PROJECT_NAME.equals(f.getAttributes().getName()))
                      	  .findAny()
                      	  .orElse(null);  
                        System.out.println("One BIM360 Project: <id>: " + project.getId() + " <name>:" + project.getAttributes().getName() ); 
                    
                        String projectId = project.getId(); 

                        //get top folders 
                        Folders folders = getTopFolders(hubId,projectId); 
                        if(folders.getData().size() ==0 )
                            throw new Exception("folders size ==0 ");
                        	
                        	//using 2 legged token, topFolders will return 
                        	//all folders, including hidden folders
                        	//print one folder info
                        	//assume specific visible  folder is what we want to test
                        	
                        	Folder folder = folders.getData().stream()
                        	  .filter(f -> BIM_FOLDER_NAME.equals(f.getAttributes().getName()))
                        	  .findAny()
                        	  .orElse(null);
                            System.out.println("One BIM360 Folder: <id>: " + folder.getId() + " <name>:" + folder.getAttributes().getName() ); 
                      
                            String folderId = folder.getId();
                            //get one folder
                            Folder folder_byGetOneFolder = getFolder(projectId,folderId );
                            
                            
                       
        } catch (ApiException e) {
            System.err.println("Error with test : " + e.getResponseBody());
        }
    }
}