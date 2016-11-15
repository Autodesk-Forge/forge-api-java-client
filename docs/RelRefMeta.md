
# RelRefMeta

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**refType** | [**RefTypeEnum**](#RefTypeEnum) |  | 
**direction** | [**DirectionEnum**](#DirectionEnum) | describes the direction of the reference relative to the resource the refs are queried for | 
**fromId** | **String** |  | 
**fromType** | [**FromTypeEnum**](#FromTypeEnum) |  | 
**toId** | **String** |  | 
**toType** | [**ToTypeEnum**](#ToTypeEnum) |  | 
**extension** | [**BaseAttributesExtensionObject**](BaseAttributesExtensionObject.md) |  | 


<a name="RefTypeEnum"></a>
## Enum: RefTypeEnum
Name | Value
---- | -----
"DERIVED" | &quot;derived&quot;
"DEPENDENCIES" | &quot;dependencies&quot;
"AUXILIARY" | &quot;auxiliary&quot;
"XREFS" | &quot;xrefs&quot;


<a name="DirectionEnum"></a>
## Enum: DirectionEnum
Name | Value
---- | -----
"FROM" | &quot;from&quot;
"TO" | &quot;to&quot;


<a name="FromTypeEnum"></a>
## Enum: FromTypeEnum
Name | Value
---- | -----
"FOLDERS" | &quot;folders&quot;
"ITEMS" | &quot;items&quot;
"VERSIONS" | &quot;versions&quot;


<a name="ToTypeEnum"></a>
## Enum: ToTypeEnum
Name | Value
---- | -----
"FOLDERS" | &quot;folders&quot;
"ITEMS" | &quot;items&quot;
"VERSIONS" | &quot;versions&quot;



