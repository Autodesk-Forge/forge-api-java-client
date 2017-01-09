# ItemsApi

All URIs are relative to *https://developer.api.autodesk.com/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getItem**](ItemsApi.md#getItem) | **GET** /data/v1/projects/{project_id}/items/{item_id} | 
[**getItemParentFolder**](ItemsApi.md#getItemParentFolder) | **GET** /data/v1/projects/{project_id}/items/{item_id}/parent | 
[**getItemRefs**](ItemsApi.md#getItemRefs) | **GET** /data/v1/projects/{project_id}/items/{item_id}/refs | 
[**getItemRelationshipsRefs**](ItemsApi.md#getItemRelationshipsRefs) | **GET** /data/v1/projects/{project_id}/items/{item_id}/relationships/refs | 
[**getItemTip**](ItemsApi.md#getItemTip) | **GET** /data/v1/projects/{project_id}/items/{item_id}/tip | 
[**getItemVersions**](ItemsApi.md#getItemVersions) | **GET** /data/v1/projects/{project_id}/items/{item_id}/versions | 
[**postItem**](ItemsApi.md#postItem) | **POST** /data/v1/projects/{project_id}/items | 
[**postItemRelationshipsRef**](ItemsApi.md#postItemRelationshipsRef) | **POST** /data/v1/projects/{project_id}/items/{item_id}/relationships/refs | 


<a name="getItem"></a>
# **getItem**
> Item getItem(projectId, itemId)



Returns a resource item by ID for any item within a given project. Resource items represent word documents, fusion design files, drawings, spreadsheets, etc. 

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **String**| the &#x60;project id&#x60; |
 **itemId** | **String**| the &#x60;item id&#x60; |

### Return type

[**Item**](Item.md)

### Authorization

[oauth2_access_code](../README.md#authentication)

### HTTP request headers

 - **Content-Type**: application/vnd.api+json
 - **Accept**: application/vnd.api+json, application/json

<a name="getItemParentFolder"></a>
# **getItemParentFolder**
> Folder getItemParentFolder(projectId, itemId)



Returns the \&quot;parent\&quot; folder for the given item. 

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **String**| the &#x60;project id&#x60; |
 **itemId** | **String**| the &#x60;item id&#x60; |

### Return type

[**Folder**](Folder.md)

### Authorization

[oauth2_access_code](../README.md#authentication)

### HTTP request headers

 - **Content-Type**: application/vnd.api+json
 - **Accept**: application/vnd.api+json, application/json

<a name="getItemRefs"></a>
# **getItemRefs**
> JsonApiCollection getItemRefs(projectId, itemId, filterType, filterId, filterExtensionType)



Returns the resources (&#x60;items&#x60;, &#x60;folders&#x60;, and &#x60;versions&#x60;) which have a custom relationship with the given &#x60;item_id&#x60;. Custom relationships can be established between an item and other resources within the &#39;data&#39; domain service (folders, items, and versions). 

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **String**| the &#x60;project id&#x60; |
 **itemId** | **String**| the &#x60;item id&#x60; |
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

<a name="getItemRelationshipsRefs"></a>
# **getItemRelationshipsRefs**
> Refs getItemRelationshipsRefs(projectId, itemId, filterType, filterId, filterRefType, filterDirection, filterExtensionType)



Returns the custom relationships that are associated to the given &#x60;item_id&#x60;. Custom relationships can be established between an item and other resources within the &#39;data&#39; domain service (folders, items, and versions). 

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **String**| the &#x60;project id&#x60; |
 **itemId** | **String**| the &#x60;item id&#x60; |
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

<a name="getItemTip"></a>
# **getItemTip**
> Version getItemTip(projectId, itemId)



Returns the \&quot;tip\&quot; version for the given item. Multiple versions of a resource item can be uploaded in a project. The tip version is the most recent one. 

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **String**| the &#x60;project id&#x60; |
 **itemId** | **String**| the &#x60;item id&#x60; |

### Return type

[**Version**](Version.md)

### Authorization

[oauth2_access_code](../README.md#authentication)

### HTTP request headers

 - **Content-Type**: application/vnd.api+json
 - **Accept**: application/vnd.api+json, application/json

<a name="getItemVersions"></a>
# **getItemVersions**
> Versions getItemVersions(projectId, itemId, filterType, filterId, filterExtensionType, filterVersionNumber, pageNumber, pageLimit)



Returns versions for the given item. Multiple versions of a resource item can be uploaded in a project. 

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **String**| the &#x60;project id&#x60; |
 **itemId** | **String**| the &#x60;item id&#x60; |
 **filterType** | **List&lt;String&gt;**| filter by the &#x60;type&#x60; of the &#x60;ref&#x60; target | [optional]
 **filterId** | **List&lt;String&gt;**| filter by the &#x60;id&#x60; of the &#x60;ref&#x60; target | [optional]
 **filterExtensionType** | **List&lt;String&gt;**| filter by the extension type | [optional]
 **filterVersionNumber** | **List&lt;Integer&gt;**| filter by &#x60;versionNumber&#x60; | [optional]
 **pageNumber** | **Integer**| specify the page number | [optional]
 **pageLimit** | **Integer**| specify the maximal number of elements per page | [optional]

### Return type

[**Versions**](Versions.md)

### Authorization

[oauth2_access_code](../README.md#authentication)

### HTTP request headers

 - **Content-Type**: application/vnd.api+json
 - **Accept**: application/vnd.api+json, application/json

<a name="postItem"></a>
# **postItem**
> ItemCreated postItem(projectId, body)



Creates a new item in the &#39;data&#39; domain service. 

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **String**| the &#x60;project id&#x60; |
 **body** | [**CreateItem**](CreateItem.md)| describe the item to be created |

### Return type

[**ItemCreated**](ItemCreated.md)

### Authorization

[oauth2_access_code](../README.md#authentication)

### HTTP request headers

 - **Content-Type**: application/vnd.api+json
 - **Accept**: application/vnd.api+json, application/json

<a name="postItemRelationshipsRef"></a>
# **postItemRelationshipsRef**
> postItemRelationshipsRef(projectId, itemId, body)



Creates a custom relationship between an item and another resource within the &#39;data&#39; domain service (folder, item, or version). 

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **String**| the &#x60;project id&#x60; |
 **itemId** | **String**| the &#x60;item id&#x60; |
 **body** | [**CreateRef**](CreateRef.md)| describe the ref to be created |

### Return type

null (empty response body)

### Authorization

[oauth2_access_code](../README.md#authentication)

### HTTP request headers

 - **Content-Type**: application/vnd.api+json
 - **Accept**: application/vnd.api+json, application/json

