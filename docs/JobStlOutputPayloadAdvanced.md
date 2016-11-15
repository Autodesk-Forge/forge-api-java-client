
# JobStlOutputPayloadAdvanced

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**format** | [**FormatEnum**](#FormatEnum) | Default format is &#x60;binary&#x60;. Possible values are &#x60;binary&#x60; or &#x60;ascii&#x60;. |  [optional]
**exportColor** | **Boolean** | Color is exported by default. If set to &#x60;true&#x60;, color is exported. If set to &#x60;false&#x60;, color is not exported. |  [optional]
**exportFileStructure** | [**ExportFileStructureEnum**](#ExportFileStructureEnum) | &#x60;single&#x60; (default): creates one STL file for all the input files (assembly file)  &#x60;multiple&#x60;: creates a separate STL file for each object  |  [optional]


<a name="FormatEnum"></a>
## Enum: FormatEnum
Name | Value
---- | -----
"BINARY" | &quot;binary&quot;
"ASCII" | &quot;ascii&quot;


<a name="ExportFileStructureEnum"></a>
## Enum: ExportFileStructureEnum
Name | Value
---- | -----
"SINGLE" | &quot;single&quot;
"MULTIPLE" | &quot;multiple&quot;



