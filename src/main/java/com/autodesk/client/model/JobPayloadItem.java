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

import com.autodesk.client.model.JobIgesOutputPayload;
import com.autodesk.client.model.JobObjOutputPayload;
import com.autodesk.client.model.JobObjOutputPayloadAdvanced;
import com.autodesk.client.model.JobStepOutputPayload;
import com.autodesk.client.model.JobStlOutputPayload;
import com.autodesk.client.model.JobSvfOutputPayload;
import com.autodesk.client.model.JobThumbnailOutputPayload;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;


/**
 * Output description object, depends of the type
 */
@ApiModel(description = "Output description object, depends of the type")

public class JobPayloadItem   {
  /**
   * The requested output types. Possible values include `svf`, `thumbnai`, `stl`, `step`, `iges`, or `obj`. For a list of supported types, call the [GET formats](https://developer.autodesk.com/en/docs/model-derivative/v2/reference/http/formats-GET) endpoint.
   */
  public enum TypeEnum {
    SVF("svf"),
    
    SVF2("svf2"),
    
    RVT("rvt"),
    
    IFC("ifc"),
    
    THUMBNAIL("thumbnail"),
    
    STL("stl"),
    
    STEP("step"),
    
    IGES("iges"),
    
    OBJ("obj");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  @JsonProperty("type")
  private TypeEnum type = null;

  /**
   * Required options for SVF type. Possible values are `2d` and `3d`.
   */
  public enum ViewsEnum {
    _2D("2d"),
    
    _3D("3d");

    private String value;

    ViewsEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  @JsonProperty("views")
  private List<ViewsEnum> views = new ArrayList<ViewsEnum>();

  @JsonProperty("advanced")
  private JobObjOutputPayloadAdvanced advanced = null;

  public JobPayloadItem type(TypeEnum type) {
    this.type = type;
    return this;
  }

   /**
   * The requested output types. Possible values include `svf`, `thumbnai`, `stl`, `step`, `iges`, or `obj`. For a list of supported types, call the [GET formats](https://developer.autodesk.com/en/docs/model-derivative/v2/reference/http/formats-GET) endpoint.
   * @return type
  **/
  @ApiModelProperty(example = "null", required = true, value = "The requested output types. Possible values include `svf`, `thumbnai`, `stl`, `step`, `iges`, or `obj`. For a list of supported types, call the [GET formats](https://developer.autodesk.com/en/docs/model-derivative/v2/reference/http/formats-GET) endpoint.")
  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public JobPayloadItem views(List<ViewsEnum> views) {
    this.views = views;
    return this;
  }

   /**
   * Get views
   * @return views
  **/
  @ApiModelProperty(example = "null", value = "")
  public List<ViewsEnum> getViews() {
    return views;
  }

  public void setViews(List<ViewsEnum> views) {
    this.views = views;
  }

  public JobPayloadItem advanced(JobObjOutputPayloadAdvanced advanced) {
    this.advanced = advanced;
    return this;
  }

   /**
   * Get advanced
   * @return advanced
  **/
  @ApiModelProperty(example = "null", value = "")
  public JobObjOutputPayloadAdvanced getAdvanced() {
    return advanced;
  }

  public void setAdvanced(JobObjOutputPayloadAdvanced advanced) {
    this.advanced = advanced;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JobPayloadItem jobPayloadItem = (JobPayloadItem) o;
    return Objects.equals(this.type, jobPayloadItem.type) &&
        Objects.equals(this.views, jobPayloadItem.views) &&
        Objects.equals(this.advanced, jobPayloadItem.advanced);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, views, advanced);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JobPayloadItem {\n");
    
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    views: ").append(toIndentedString(views)).append("\n");
    sb.append("    advanced: ").append(toIndentedString(advanced)).append("\n");
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

