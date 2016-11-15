
# PostBucketsPayload

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**bucketKey** | **String** | Bucket key | 
**allow** | [**List&lt;PostBucketsPayloadAllow&gt;**](PostBucketsPayloadAllow.md) |  |  [optional]
**policyKey** | [**PolicyKeyEnum**](#PolicyKeyEnum) | [Data retention policy](https://developer.autodesk.com/en/docs/data/v2/overview/retention-policy/)  Acceptable values: &#x60;transient&#x60;, &#x60;temporary&#x60; or &#x60;persistent&#x60;  | 


<a name="PolicyKeyEnum"></a>
## Enum: PolicyKeyEnum
Name | Value
---- | -----
"TRANSIENT" | &quot;transient&quot;
"TEMPORARY" | &quot;temporary&quot;
"PERSISTENT" | &quot;persistent&quot;



