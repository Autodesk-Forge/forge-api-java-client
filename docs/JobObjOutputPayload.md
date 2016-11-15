
# JobObjOutputPayload

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**type** | [**TypeEnum**](#TypeEnum) | The requested output types. Possible values include &#x60;svf&#x60;, &#x60;thumbnai&#x60;, &#x60;stl&#x60;, &#x60;step&#x60;, &#x60;iges&#x60;, or &#x60;obj&#x60;. For a list of supported types, call the [GET formats](https://developer.autodesk.com/en/docs/model-derivative/v2/reference/http/formats-GET) endpoint. | 
**advanced** | [**JobObjOutputPayloadAdvanced**](JobObjOutputPayloadAdvanced.md) |  |  [optional]


<a name="TypeEnum"></a>
## Enum: TypeEnum
Name | Value
---- | -----
"SVF" | &quot;svf&quot;
"THUMBNAIL" | &quot;thumbnail&quot;
"STL" | &quot;stl&quot;
"STEP" | &quot;step&quot;
"IGES" | &quot;iges&quot;
"OBJ" | &quot;obj&quot;



