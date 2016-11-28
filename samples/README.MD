# Forge Java Sample App

## Overview
This sample app uses the Forge Java SDK to demonstrate the [OAuth](https://developer.autodesk.com/en/docs/oauth/v2/overview/) and [Data Management](https://developer.autodesk.com/en/docs/data/v2/overview/) Forge APIs. It shows a typical workflow:

* [Create an authentication token](https://developer.autodesk.com/en/docs/oauth/v2/tutorials/get-2-legged-token/)
* [Create a bucket](https://developer.autodesk.com/en/docs/data/v2/reference/http/buckets-POST/)
* [Upload a file to the bucket](https://developer.autodesk.com/en/docs/data/v2/reference/http/buckets-:bucketKey-objects-:objectName-PUT/)
* [Get a list of buckets](https://developer.autodesk.com/en/docs/data/v2/reference/http/buckets-GET/)
* [Delete the file](https://developer.autodesk.com/en/docs/data/v2/reference/http/buckets-:bucketKey-objects-:objectName-DELETE/)

### Requirements
* Java version 7 and above.
* A registered app on the <a href="https://developer.autodesk.com/myapps" target="_blank">Forge Developer portal</a>.

### Installation
Clone the following repository:<br />
    ```https://github.com/Autodesk-Forge/forge-api-java-client.git```


### Create an App

[Create an app](https://developer.autodesk.com/en/docs/oauth/v2/tutorials/create-app/) on the Forge Developer portal, and select the Data Management API. Note the client ID and client secret.

### Configure the Parameters

Before running the app you need to configure the following parameters from the *Main.java* file:

* Replace `CLIENT_ID` and `CLIENT_SECRET` with the client ID and client secret generated when creating the app.
Note that the app uses a <a href="https://developer.autodesk.com/en/docs/oauth/v2/overview/" target="_blank">OAuth 2.0</a> client to retrieve the 2-legged access tokens.

* Replace `BUCKET_KEY` with a name for the bucket.

* Select a file, and replace `FILE_NAME` and `FILE_PATH` with the filename and file path.

### Run the App
Run the app from your IDE console.

## Support
forge.help@autodesk.com
