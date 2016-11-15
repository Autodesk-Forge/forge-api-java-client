
# JobObjOutputPayloadAdvanced

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**exportFileStructure** | [**ExportFileStructureEnum**](#ExportFileStructureEnum) | &#x60;single&#x60; (default): creates one OBJ file for all the input files (assembly file)  &#x60;multiple&#x60;: creates a separate OBJ file for each object  |  [optional]
**modelGuid** | **String** | Required for geometry extractions. The model view ID (guid). |  [optional]
**objectIds** | **List&lt;String&gt;** | Required for geometry extractions. List object ids to be translated. -1 will extract the entire model.  |  [optional]


<a name="ExportFileStructureEnum"></a>
## Enum: ExportFileStructureEnum
Name | Value
---- | -----
"SINGLE" | &quot;single&quot;
"MULTIPLE" | &quot;multiple&quot;



