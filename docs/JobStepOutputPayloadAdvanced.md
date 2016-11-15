
# JobStepOutputPayloadAdvanced

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**applicationProtocol** | [**ApplicationProtocolEnum**](#ApplicationProtocolEnum) | A STEP file can be generated with the following Application Protocols: &#x60;203&#x60; for configuration controlled design, &#x60;214&#x60; for core data for automotive mechanical design processes, &#x60;242&#x60; for managed model based 3D engineering. By default, &#x60;214&#x60; will be exported.  |  [optional]
**tolerance** | **Float** | Possible values are between &#x60;0&#x60; and &#x60;1&#x60;. By default it is set at 0.001. |  [optional]


<a name="ApplicationProtocolEnum"></a>
## Enum: ApplicationProtocolEnum
Name | Value
---- | -----
"_203" | &quot;203&quot;
"_214" | &quot;214&quot;
"_242" | &quot;242&quot;



