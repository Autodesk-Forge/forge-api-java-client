/*
 * Forge SDK
 * The Forge Platform contains an expanding collection of web service components that can be used with Autodesk cloud-based products or your own technologies. Take advantage of Autodesk’s expertise in design and engineering.
 *
 * OpenAPI spec version: 0.1.0
 * Contact: forge.help@autodesk.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package com.autodesk.client.model;

import java.util.Objects;

import com.autodesk.client.model.JobPayloadItem;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;


/**
 * Group of outputs
 */
@ApiModel(description = "Group of outputs")

public class JobPayloadOutput   {
  @JsonProperty("formats")
  private List<JobPayloadItem> formats = new ArrayList<JobPayloadItem>();

  public JobPayloadOutput formats(List<JobPayloadItem> formats) {
    this.formats = formats;
    return this;
  }
  

   /**
   * Group of requested formats/types. User can request multiple formats.
   * @return formats
  **/
  @ApiModelProperty(example = "null", required = true, value = "Group of requested formats/types. User can request multiple formats.")
  public List<JobPayloadItem> getFormats() {
    return formats;
  }

  public void setFormats(List<JobPayloadItem> formats) {
    this.formats = formats;
  }

  @JsonProperty("destination")
  private JobPayloadDestination destination = new JobPayloadDestination();

  public JobPayloadDestination destination() {
    return this.destination;
  }
  
  public void setDestination(JobPayloadDestination o) {
	    this.destination = o;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JobPayloadOutput jobPayloadOutput = (JobPayloadOutput) o;
    return Objects.equals(this.formats, jobPayloadOutput.formats);
  }

  @Override
  public int hashCode() {
    return Objects.hash(formats);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JobPayloadOutput {\n");
    
    sb.append("    formats: ").append(toIndentedString(formats)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

