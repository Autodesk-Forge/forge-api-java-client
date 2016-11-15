
# ManifestChildren

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**type** | [**TypeEnum**](#TypeEnum) | Type of this JSON object | 
**role** | [**RoleEnum**](#RoleEnum) | Output file type | 
**name** | **String** | Output file type |  [optional]
**hasThumbnail** | **Boolean** | Indicates if a thumbnail has been generated  |  [optional]
**mime** | **String** | MIME type of the generated file | 
**urn** | **String** | Output file URN; used as a file identifier |  [optional]
**progress** | **String** | Translation progress for requested entity |  [optional]
**status** | [**StatusEnum**](#StatusEnum) | Status of the requested entity; possible values are: &#x60;pending&#x60;, &#x60;success&#x60;, &#x60;inprogress&#x60;, &#x60;failed&#x60;, &#x60;timeout&#x60; and &#x60;partialsuccess&#x60;  |  [optional]
**resolution** | **List&lt;String&gt;** | Available thumbnail resolution |  [optional]
**modelGUID** | **String** |  |  [optional]
**objectIds** | **List&lt;Integer&gt;** |  |  [optional]
**messages** | [**Messages**](Messages.md) |  |  [optional]


<a name="TypeEnum"></a>
## Enum: TypeEnum
Name | Value
---- | -----
"RESOURCE" | &quot;resource&quot;
"MANIFEST" | &quot;manifest&quot;
"GEOMETRY" | &quot;geometry&quot;
"VIEW" | &quot;view&quot;


<a name="RoleEnum"></a>
## Enum: RoleEnum
Name | Value
---- | -----
"_2D" | &quot;2d&quot;
"_3D" | &quot;3d&quot;
"GRAPHICS" | &quot;graphics&quot;
"MANIFEST" | &quot;manifest&quot;
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



