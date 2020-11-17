package com.autodesk.client.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"name",
"displayName",
"createTime",
"createUserId",
"createUserName",
"lastModifiedTime",
"lastModifiedUserId",
"lastModifiedUserName",
"lastModifiedTimeRollup",
"objectCount",
"hidden",
"extension"
})
public class JsonApiAttributes {

@JsonProperty("name")
private String name;
@JsonProperty("displayName")
private String displayName;
@JsonProperty("createTime")
private String createTime;
@JsonProperty("createUserId")
private String createUserId;
@JsonProperty("createUserName")
private String createUserName;
@JsonProperty("lastModifiedTime")
private String lastModifiedTime;
@JsonProperty("lastModifiedUserId")
private String lastModifiedUserId;
@JsonProperty("lastModifiedUserName")
private String lastModifiedUserName;
@JsonProperty("lastModifiedTimeRollup")
private String lastModifiedTimeRollup;
@JsonProperty("objectCount")
private Integer objectCount;
@JsonProperty("hidden")
private Boolean hidden;
@JsonProperty("extension")
private BaseAttributesExtensionObject extension;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("name")
public String getName() {
return name;
}

@JsonProperty("name")
public void setName(String name) {
this.name = name;
}

@JsonProperty("displayName")
public String getDisplayName() {
return displayName;
}

@JsonProperty("displayName")
public void setDisplayName(String displayName) {
this.displayName = displayName;
}

@JsonProperty("createTime")
public String getCreateTime() {
return createTime;
}

@JsonProperty("createTime")
public void setCreateTime(String createTime) {
this.createTime = createTime;
}

@JsonProperty("createUserId")
public String getCreateUserId() {
return createUserId;
}

@JsonProperty("createUserId")
public void setCreateUserId(String createUserId) {
this.createUserId = createUserId;
}

@JsonProperty("createUserName")
public String getCreateUserName() {
return createUserName;
}

@JsonProperty("createUserName")
public void setCreateUserName(String createUserName) {
this.createUserName = createUserName;
}

@JsonProperty("lastModifiedTime")
public String getLastModifiedTime() {
return lastModifiedTime;
}

@JsonProperty("lastModifiedTime")
public void setLastModifiedTime(String lastModifiedTime) {
this.lastModifiedTime = lastModifiedTime;
}

@JsonProperty("lastModifiedUserId")
public String getLastModifiedUserId() {
return lastModifiedUserId;
}

@JsonProperty("lastModifiedUserId")
public void setLastModifiedUserId(String lastModifiedUserId) {
this.lastModifiedUserId = lastModifiedUserId;
}

@JsonProperty("lastModifiedUserName")
public String getLastModifiedUserName() {
return lastModifiedUserName;
}

@JsonProperty("lastModifiedUserName")
public void setLastModifiedUserName(String lastModifiedUserName) {
this.lastModifiedUserName = lastModifiedUserName;
}

@JsonProperty("lastModifiedTimeRollup")
public String getLastModifiedTimeRollup() {
return lastModifiedTimeRollup;
}

@JsonProperty("lastModifiedTimeRollup")
public void setLastModifiedTimeRollup(String lastModifiedTimeRollup) {
this.lastModifiedTimeRollup = lastModifiedTimeRollup;
}

@JsonProperty("objectCount")
public Integer getObjectCount() {
return objectCount;
}

@JsonProperty("objectCount")
public void setObjectCount(Integer objectCount) {
this.objectCount = objectCount;
}

@JsonProperty("hidden")
public Boolean getHidden() {
return hidden;
}

@JsonProperty("hidden")
public void setHidden(Boolean hidden) {
this.hidden = hidden;
}

@JsonProperty("extension")
public BaseAttributesExtensionObject getExtension() {
return extension;
}

@JsonProperty("extension")
public void setExtension(BaseAttributesExtensionObject extension) {
this.extension = extension;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

@Override
public String toString() {
return new ToStringBuilder(this).append("name", name).append("displayName", displayName).append("createTime", createTime).append("createUserId", createUserId).append("createUserName", createUserName).append("lastModifiedTime", lastModifiedTime).append("lastModifiedUserId", lastModifiedUserId).append("lastModifiedUserName", lastModifiedUserName).append("lastModifiedTimeRollup", lastModifiedTimeRollup).append("objectCount", objectCount).append("hidden", hidden).append("extension", extension).append("additionalProperties", additionalProperties).toString();
}

@Override
public int hashCode() {
return new HashCodeBuilder().append(createUserId).append(objectCount).append(extension).append(lastModifiedTime).append(hidden).append(displayName).append(lastModifiedTimeRollup).append(createUserName).append(lastModifiedUserName).append(createTime).append(name).append(lastModifiedUserId).append(additionalProperties).toHashCode();
}

@Override
public boolean equals(Object other) {
if (other == this) {
return true;
}
if ((other instanceof JsonApiAttributes) == false) {
return false;
}
JsonApiAttributes rhs = ((JsonApiAttributes) other);
return new EqualsBuilder().append(createUserId, rhs.createUserId).append(objectCount, rhs.objectCount).append(extension, rhs.extension).append(lastModifiedTime, rhs.lastModifiedTime).append(hidden, rhs.hidden).append(displayName, rhs.displayName).append(lastModifiedTimeRollup, rhs.lastModifiedTimeRollup).append(createUserName, rhs.createUserName).append(lastModifiedUserName, rhs.lastModifiedUserName).append(createTime, rhs.createTime).append(name, rhs.name).append(lastModifiedUserId, rhs.lastModifiedUserId).append(additionalProperties, rhs.additionalProperties).isEquals();
}

}