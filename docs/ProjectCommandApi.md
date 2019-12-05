# ProjectCommandApi

All URIs are relative to *https://developer.api.autodesk.com/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getPublishModelJob**](ProjectCommandApi.md#getPublishModelJob) | **POST** /data/v1/projects/{project_id}/commands | 
[**publishModel**](ProjectCommandApi.md#publishModel) | **GET** /data/v1/projects/{project_id}/commands | 

<a name="getPublishModelJob"></a>
# **getPublishModelJob**
> Project Command getPublishModelJob(projectId, urn)



Returns if the command was successfully executed. 

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **String**| the &#x60;project id&#x60; for the project |
 **urn** | **String**| The &#x60;URN&#x60; of the resource | 
 
### Return type

[**CommandPublish**](CommandPublish.md)

### Authorization

[oauth2_access_code](../README.md#authentication)

### HTTP request headers

 - **Content-Type**: application/vnd.api+json
 - **Accept**: application/vnd.api+json, application/json

<a name="publishModel"></a>
# **publishModel**
> Project Command publishModel(projectId, urn)



Returns if the command was successfully executed. 

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **String**| the &#x60;project id&#x60; for the project |
 **urn** | **String**| The &#x60;URN&#x60; of the resource | 
 
### Return type

[**CommandPublish**](CommandPublish.md)

### Authorization

[oauth2_access_code](../README.md#authentication)

### HTTP request headers

 - **Content-Type**: application/vnd.api+json
 - **Accept**: application/vnd.api+json, application/json
