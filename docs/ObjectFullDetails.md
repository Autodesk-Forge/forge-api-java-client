
# ObjectFullDetails

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**bucketKey** | **String** | Bucket key |  [optional]
**objectId** | **String** | Object URN |  [optional]
**objectKey** | **String** | Object name |  [optional]
**sha1** | **byte[]** | Object SHA1 |  [optional]
**size** | **Integer** | Object size |  [optional]
**contentType** | **String** | Object content-type |  [optional]
**location** | **String** | URL to download the object |  [optional]
**blockSizes** | **List&lt;Integer&gt;** | For delta-encoding. Represents whether a signature exists at a specific block size |  [optional]
**deltas** | [**List&lt;ObjectFullDetailsDeltas&gt;**](ObjectFullDetailsDeltas.md) | Patch files available for download related to this object |  [optional]



