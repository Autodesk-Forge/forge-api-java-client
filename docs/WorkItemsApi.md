# WorkItemsApi

All URIs are relative to *https://developer.api.autodesk.com/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createWorkItem**](WorkItemsApi.md#createWorkItem) | **POST** /autocad.io/us-east/v2/WorkItems | Creates a new WorkItem.
[**deleteWorkItem**](WorkItemsApi.md#deleteWorkItem) | **DELETE** /autocad.io/us-east/v2/WorkItems(&#39;{id}&#39;) | Removes a specific WorkItem.
[**getAllWorkItems**](WorkItemsApi.md#getAllWorkItems) | **GET** /autocad.io/us-east/v2/WorkItems | Returns the details of all WorkItems.
[**getWorkItem**](WorkItemsApi.md#getWorkItem) | **GET** /autocad.io/us-east/v2/WorkItems(&#39;{id}&#39;) | Returns the details of a specific WorkItem.


<a name="createWorkItem"></a>
# **createWorkItem**
> WorkItemResp createWorkItem(workItem)

Creates a new WorkItem.

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **workItem** | [**WorkItem**](WorkItem.md)|  |

### Return type

[**WorkItemResp**](WorkItemResp.md)

### Authorization

[oauth2_application](../README.md#authentication)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/vnd.api+json, application/json

<a name="deleteWorkItem"></a>
# **deleteWorkItem**
> deleteWorkItem(id)

Removes a specific WorkItem.

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |

### Return type

null (empty response body)

### Authorization

[oauth2_application](../README.md#authentication)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/vnd.api+json, application/json

<a name="getAllWorkItems"></a>
# **getAllWorkItems**
> DesignAutomationWorkItems getAllWorkItems(skip)

Returns the details of all WorkItems.

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **skip** | **Integer**|  | [optional]

### Return type

[**DesignAutomationWorkItems**](DesignAutomationWorkItems.md)

### Authorization

[oauth2_application](../README.md#authentication)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/vnd.api+json, application/json

<a name="getWorkItem"></a>
# **getWorkItem**
> WorkItemResp getWorkItem(id)

Returns the details of a specific WorkItem.

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |

### Return type

[**WorkItemResp**](WorkItemResp.md)

### Authorization

[oauth2_application](../README.md#authentication)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/vnd.api+json, application/json

