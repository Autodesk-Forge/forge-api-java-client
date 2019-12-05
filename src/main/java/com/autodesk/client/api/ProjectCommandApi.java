package com.autodesk.client.api;

import com.autodesk.client.*;
import com.autodesk.client.auth.Authentication;
import com.autodesk.client.auth.Credentials;
import com.autodesk.client.model.*;
import com.sun.jersey.api.client.GenericType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProjectCommandApi {

    public enum TypeEnum {
        C4RModelGetPublishJob("commands:autodesk.bim360:C4RModelGetPublishJob"),

        C4RModelPublish("commands:autodesk.bim360:C4RModelPublish");

        private String value;

        TypeEnum(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    public enum VersionEnum {
        _0("1.0.0");

        private String value;

        VersionEnum(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    private ApiClient apiClient;

    public ProjectCommandApi() {
        this(Configuration.getDefaultApiClient());
    }

    public ProjectCommandApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Verifies whether a Collaboration for Revit (C4R) model needs to be published to BIM 360 Docs.
     *
     * @param projectId the &#x60;project id&#x60; (required)
     * @param urn the urn of the object (required)
     * @return VersionCreated
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<CommandPublish> getPublishModelJob(String projectId, String urn, Authentication oauth2, Credentials credentials) throws ApiException, Exception {

        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new ApiException(400, "Missing the required parameter 'projectId' when calling postVersion");
        }

        if (urn == null) {
            throw new ApiException(400, "Missing the required parameter 'urn' when calling postVersion");
        }

        // create path and map variables
        String localVarPath = "/data/v1/projects/{project_id}/commands".replaceAll("\\{format\\}","json")
                .replaceAll("\\{" + "project_id" + "\\}", apiClient.escapeString(projectId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
                "application/vnd.api+json", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {
                "application/vnd.api+json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        Object localVarPostBody = createGetPublishModelBody(urn, TypeEnum.C4RModelGetPublishJob);
        GenericType<CommandPublish> localVarReturnType = new GenericType<CommandPublish>() {};
        return apiClient.invokeAPI(oauth2, credentials, localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarReturnType);
    }

    /**
     * Publishes the latest version of a Collaboration for Revit (C4R) model to BIM 360 Docs. This enables other people to view, search, and socially interact with the model.
     * Note that only the 3D default view and sheets are published.
     *
     * @param projectId the &#x60;project id&#x60; (required)
     * @param urn the urn of the object (required)
     * @return VersionCreated
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<CommandPublish> publishModel(String projectId, String urn, Authentication oauth2, Credentials credentials) throws ApiException, Exception {

        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new ApiException(400, "Missing the required parameter 'projectId' when calling postVersion");
        }

        if (urn == null) {
            throw new ApiException(400, "Missing the required parameter 'urn' when calling postVersion");
        }

        // create path and map variables
        String localVarPath = "/data/v1/projects/{project_id}/commands"
                .replaceAll("\\{" + "project_id" + "\\}", apiClient.escapeString(projectId.toString()));

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
                "application/vnd.api+json", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {
                "application/vnd.api+json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        Object localVarPostBody = createGetPublishModelBody(urn, TypeEnum.C4RModelPublish);
        GenericType<CommandPublish> localVarReturnType = new GenericType<CommandPublish>() {};
        return apiClient.invokeAPI(oauth2, credentials, localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarReturnType);
    }

    /**
     * Creates the body to be sent in the payload of GetPublishModelBody
     * @param urn
     * @return CreateVersion
     */
    private CreateVersion createGetPublishModelBody(String urn, TypeEnum type) {

        // Creates the body and data to add
        CreateVersion body = new CreateVersion();
        CreateVersionData data = new CreateVersionData();

        // Creates the attributes
        CreateStorageDataAttributes attributes = new CreateStorageDataAttributes();
        BaseAttributesExtensionObject extensionObject = new BaseAttributesExtensionObject();
        extensionObject.setType(type.toString());
        extensionObject.setVersion(VersionEnum._0.toString());

        attributes.setExtension(extensionObject);
        data.setAttributes(attributes);

        // Creates the relationships
        CreateVersionDataRelationships relationships = new CreateVersionDataRelationships();
        CreateVersionDataRelationshipsItem item = new CreateVersionDataRelationshipsItem();

        CreateVersionDataRelationshipsItemData itemData = new CreateVersionDataRelationshipsItemData();
        itemData.setType(CreateVersionDataRelationshipsItemData.TypeEnum.ITEMS);
        itemData.setId(urn);
        item.data(itemData);

        relationships.setItem(item);
        data.setRelationships(relationships);

        body.setData(data);

        JsonApiVersionJsonapi jsonApiVersionJsonapi = new JsonApiVersionJsonapi();
        jsonApiVersionJsonapi.setVersion(JsonApiVersionJsonapi.VersionEnum._0);
        body.setJsonapi(jsonApiVersionJsonapi);

        return body;
    }


}
