# VersionsApi

All URIs are relative to *https://developer.api.autodesk.com/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getVersion**](VersionsApi.md#getVersion) | **GET** /data/v1/projects/{project_id}/versions/{version_id} | 
[**getVersionItem**](VersionsApi.md#getVersionItem) | **GET** /data/v1/projects/{project_id}/versions/{version_id}/item | 
[**getVersionRefs**](VersionsApi.md#getVersionRefs) | **GET** /data/v1/projects/{project_id}/versions/{version_id}/refs | 
[**getVersionRelationshipsRefs**](VersionsApi.md#getVersionRelationshipsRefs) | **GET** /data/v1/projects/{project_id}/versions/{version_id}/relationships/refs | 
[**postVersionRelationshipsRef**](VersionsApi.md#postVersionRelationshipsRef) | **POST** /data/v1/projects/{project_id}/versions/{version_id}/relationships/refs | 


<a name="getVersion"></a>
# **getVersion**
> Version getVersion(projectId, versionId)



Returns the version with the given &#x60;version_id&#x60;. 

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **String**| the &#x60;project id&#x60; |
 **versionId** | **String**| the &#x60;version id&#x60; |

### Return type

[**Version**](Version.md)

### Authorization

[oauth2_access_code](../README.md#authentication)

### HTTP request headers

 - **Content-Type**: application/vnd.api+json
 - **Accept**: application/vnd.api+json, application/json

<a name="getVersionItem"></a>
# **getVersionItem**
> Item getVersionItem(projectId, versionId)



Returns the item the given version is associated with. 

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **String**| the &#x60;project id&#x60; |
 **versionId** | **String**| the &#x60;version id&#x60; |

### Return type

[**Item**](Item.md)

### Authorization

[oauth2_access_code](../README.md#authentication)

### HTTP request headers

 - **Content-Type**: application/vnd.api+json
 - **Accept**: application/vnd.api+json, application/json

<a name="getVersionRefs"></a>
# **getVersionRefs**
> JsonApiCollection getVersionRefs(projectId, versionId, filterType, filterId, filterExtensionType)



Returns the resources (&#x60;items&#x60;, &#x60;folders&#x60;, and &#x60;versions&#x60;) which have a custom relationship with the given &#x60;version_id&#x60;. Custom relationships can be established between a version of an item and other resources within the &#39;data&#39; domain service (folders, items, and versions). 

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **String**| the &#x60;project id&#x60; |
 **versionId** | **String**| the &#x60;version id&#x60; |
 **filterType** | **List&lt;String&gt;**| filter by the &#x60;type&#x60; of the &#x60;ref&#x60; target | [optional]
 **filterId** | **List&lt;String&gt;**| filter by the &#x60;id&#x60; of the &#x60;ref&#x60; target | [optional]
 **filterExtensionType** | **List&lt;String&gt;**| filter by the extension type | [optional]

### Return type

[**JsonApiCollection**](JsonApiCollection.md)

### Authorization

[oauth2_access_code](../README.md#authentication)

### HTTP request headers

 - **Content-Type**: application/vnd.api+json
 - **Accept**: application/vnd.api+json, application/json

<a name="getVersionRelationshipsRefs"></a>
# **getVersionRelationshipsRefs**
> Refs getVersionRelationshipsRefs(projectId, versionId, filterType, filterId, filterRefType, filterDirection, filterExtensionType)



Returns the custom relationships that are associated to the given &#x60;version_id&#x60;. Custom relationships can be established between a version of an item and other resources within the &#39;data&#39; domain service (folders, items, and versions). 

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **String**| the &#x60;project id&#x60; |
 **versionId** | **String**| the &#x60;version id&#x60; |
 **filterType** | **List&lt;String&gt;**| filter by the &#x60;type&#x60; of the &#x60;ref&#x60; target | [optional]
 **filterId** | **List&lt;String&gt;**| filter by the &#x60;id&#x60; of the &#x60;ref&#x60; target | [optional]
 **filterRefType** | **List&lt;String&gt;**| filter by &#x60;refType&#x60; | [optional]
 **filterDirection** | **String**| filter by the direction of the reference | [optional] [enum: from, to]
 **filterExtensionType** | **List&lt;String&gt;**| filter by the extension type | [optional]

### Return type

[**Refs**](Refs.md)

### Authorization

[oauth2_access_code](../README.md#authentication)

### HTTP request headers

 - **Content-Type**: application/vnd.api+json
 - **Accept**: application/vnd.api+json, application/json

<a name="postVersionRelationshipsRef"></a>
# **postVersionRelationshipsRef**
> postVersionRelationshipsRef(projectId, versionId, body)



Creates a custom relationship between a version and another resource within the &#39;data&#39; domain service (folder, item, or version). 

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **String**| the &#x60;project id&#x60; |
 **versionId** | **String**| the &#x60;version id&#x60; |
 **body** | [**CreateRef**](CreateRef.md)| describe the ref to be created |

### Return type

null (empty response body)

### Authorization

[oauth2_access_code](../README.md#authentication)

### HTTP request headers

 - **Content-Type**: application/vnd.api+json
 - **Accept**: application/vnd.api+json, application/json

