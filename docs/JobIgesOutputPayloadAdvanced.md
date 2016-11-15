
# JobIgesOutputPayloadAdvanced

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**tolerance** | **Float** | Possible values are between &#x60;0&#x60; and &#x60;1&#x60;. By default it is set at 0.001. |  [optional]
**surfaceType** | [**SurfaceTypeEnum**](#SurfaceTypeEnum) | Possible values are &#x60;bounded&#x60;, &#x60;trimmed&#x60; and &#x60;wireframe&#x60;. By default it is set to bounded surface. |  [optional]
**sheetType** | [**SheetTypeEnum**](#SheetTypeEnum) | Export the sheet body to IGES. &#x60;open&#x60;, &#x60;shell&#x60;, &#x60;surface&#x60; or &#x60;wireframe&#x60;. By default, it is set to &#x60;surface&#x60;. |  [optional]
**solidType** | [**SolidTypeEnum**](#SolidTypeEnum) | Export the solid body to IGES &#x60;solid&#x60;, &#x60;surface&#x60; or &#x60;wireframe&#x60;. By default, it is set to &#x60;solid&#x60;. |  [optional]


<a name="SurfaceTypeEnum"></a>
## Enum: SurfaceTypeEnum
Name | Value
---- | -----
"BOUNDED" | &quot;bounded&quot;
"TRIMMED" | &quot;trimmed&quot;
"WIREFRAME" | &quot;wireframe&quot;


<a name="SheetTypeEnum"></a>
## Enum: SheetTypeEnum
Name | Value
---- | -----
"OPEN" | &quot;open&quot;
"SURFACE" | &quot;surface&quot;
"SHELL" | &quot;shell&quot;
"WIREFRAME" | &quot;wireframe&quot;


<a name="SolidTypeEnum"></a>
## Enum: SolidTypeEnum
Name | Value
---- | -----
"SOLID" | &quot;solid&quot;
"SURFACE" | &quot;surface&quot;
"WIREFRAME" | &quot;wireframe&quot;



