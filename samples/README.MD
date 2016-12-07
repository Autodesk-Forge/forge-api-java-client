# Forge Java Sample App

## Overview
This sample app uses the Forge Java SDK to introduces the [OAuth](https://developer.autodesk.com/en/docs/oauth/v2/overview/) and [Data Management](https://developer.autodesk.com/en/docs/data/v2/overview/) Forge APIs. It shows the following workflow:

* Create a 2-legged authentication token
* Create a bucket (an arbitrary space to store objects)
* Upload a file to the bucket
* Get a list of buckets
* Delete the file

### Requirements
* Java version 7 and above.

### Installation
Clone the following repository:<br />
    ```https://github.com/Autodesk-Forge/forge-api-java-client.git```


### Create an App

[Create an app](https://developer.autodesk.com/en/docs/oauth/v2/tutorials/create-app/) on the Forge Developer portal, and ensure that you select the Data Management API. Note the client ID and client secret.

### Configure the Parameters

Before running the app you need to configure the following parameters from the *Main.java* file:

* Replace `CLIENT_ID` and `CLIENT_SECRET` with the client ID and client secret generated when creating the app.

* Replace `BUCKET_KEY` with a unique name for the bucket.

* Select a file, and replace `FILE_NAME` and `FILE_PATH` with the filename and file path.

### Run the App
Run the app from your IDE console.

## Support
forge.help@autodesk.com
