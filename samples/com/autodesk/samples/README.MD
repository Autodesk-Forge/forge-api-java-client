# Forge Java Sample App

## Overview
This sample app uses the Forge Java SDK to introduce the [OAuth](https://developer.autodesk.com/en/docs/oauth/v2/overview/), [Data Management](https://developer.autodesk.com/en/docs/data/v2/overview/) and [Model Derivative](https://developer.autodesk.com/en/docs/model-derivative/v2/overview/) Forge APIs, as well as the [Viewer](https://developer.autodesk.com/en/docs/viewer/v2/overview/) JavaScript library. It shows the following typical workflow:

* Create a 2-legged authentication token
* Create a bucket (an arbitrary space to store objects)
* Upload a file to the bucket
* Prepare the file for displaying in the Viewer (translate the file into SVF format)
* Display the translated file in the Viewer

### Requirements
Java version 7 and above.

### Installation
Clone the following repository:<br />
    ```https://github.com/Autodesk-Forge/forge-api-java-client.git```


### Create an App

[Create an app](https://developer.autodesk.com/en/docs/oauth/v2/tutorials/create-app/) on the Forge Developer portal, and ensure that you select the Data Management and Model Derivative APIs. Note the client ID and client secret.

### Configure the Parameters

Open the *Main.java* file or  *MainMetadata.java* file, and replace `CLIENT_ID` and `CLIENT_SECRET` with the client ID and client secret generated when creating the app.
The demo file **rac_basic_sample_project.rvt** can be found at https://knowledge.autodesk.com/support/revit-products/getting-started/caas/CloudHelp/cloudhelp/2018/ENU/Revit-GetStarted/files/GUID-61EF2F22-3A1F-4317-B925-1E85F138BE88-htm.html.
Download it and put into the same folder. Or use your own model.

Note that depending on your IDE, you might need to mark the *samples* directory as the source root directory.

### Run the App
Run the app from your IDE console.

To test MetaData of a model,

## Support
forge.help@autodesk.com
