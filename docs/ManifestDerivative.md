
# ManifestDerivative

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **String** | Output file type | 
**hasThumbnail** | **Boolean** | Indicates if a thumbnail has been generated | 
**outputType** | [**OutputTypeEnum**](#OutputTypeEnum) |  |  [optional]
**progress** | **String** | Translation progress for requested entity | 
**status** | [**StatusEnum**](#StatusEnum) | Status of the requested entity; possible values are: &#x60;pending&#x60;, &#x60;success&#x60;, &#x60;inprogress&#x60;, &#x60;failed&#x60;, &#x60;timeout&#x60; and &#x60;partialsuccess&#x60;  | 
**children** | [**List&lt;ManifestChildren&gt;**](ManifestChildren.md) |  | 


<a name="OutputTypeEnum"></a>
## Enum: OutputTypeEnum
Name | Value
---- | -----
"STL" | &quot;stl&quot;
"STEP" | &quot;step&quot;
"IGES" | &quot;iges&quot;
"OBJ" | &quot;obj&quot;
"SVF" | &quot;svf&quot;
"THUMBNAIL" | &quot;thumbnail&quot;


<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----
"PENDING" | &quot;pending&quot;
"INPROGRESS" | &quot;inprogress&quot;
"SUCCESS" | &quot;success&quot;
"FAILED" | &quot;failed&quot;
"TIMEOUT" | &quot;timeout&quot;
"PARTIALSUCCESS" | &quot;partialsuccess&quot;



