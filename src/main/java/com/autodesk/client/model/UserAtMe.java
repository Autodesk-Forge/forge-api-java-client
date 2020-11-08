
package com.autodesk.client.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;


public class UserAtMe {

@JsonProperty("userId")
private String userId;
@JsonProperty("userName")
private String userName;
@JsonProperty("emailId")
private String emailId;
@JsonProperty("firstName")
private String firstName;
@JsonProperty("lastName")
private String lastName;
@JsonProperty("emailVerified")
private Boolean emailVerified;
@JsonProperty("2FaEnabled")
private Boolean _2FaEnabled;
@JsonProperty("countryCode")
private String countryCode;
@JsonProperty("language")
private String language;
@JsonProperty("optin")
private Boolean optin;
@JsonProperty("lastModified")
private String lastModified;
@JsonProperty("profileImages")
private ProfileImages profileImages;
@JsonProperty("ldapInfo")
private LdapInfo ldapInfo;
@JsonProperty("socialUserInfoList")
private List<Object> socialUserInfoList = null;
@JsonProperty("twoFactorAuthType")
private String twoFactorAuthType;
@JsonProperty("contactMode")
private String contactMode;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* No args constructor for use in serialization
*
*/
public UserAtMe() {
}

/**
*
* @param socialUserInfoList
* @param lastName
* @param profileImages
* @param optin
* @param emailId
* @param language
* @param userName
* @param userId
* @param twoFactorAuthType
* @param contactMode
* @param firstName
* @param emailVerified
* @param ldapInfo
* @param _2FaEnabled
* @param countryCode
* @param lastModified
*/
public UserAtMe(String userId, String userName, String emailId, String firstName, String lastName, Boolean emailVerified, Boolean _2FaEnabled, String countryCode, String language, Boolean optin, String lastModified, ProfileImages profileImages, LdapInfo ldapInfo, List<Object> socialUserInfoList, String twoFactorAuthType, String contactMode) {
super();
this.userId = userId;
this.userName = userName;
this.emailId = emailId;
this.firstName = firstName;
this.lastName = lastName;
this.emailVerified = emailVerified;
this._2FaEnabled = _2FaEnabled;
this.countryCode = countryCode;
this.language = language;
this.optin = optin;
this.lastModified = lastModified;
this.profileImages = profileImages;
this.ldapInfo = ldapInfo;
this.socialUserInfoList = socialUserInfoList;
this.twoFactorAuthType = twoFactorAuthType;
this.contactMode = contactMode;
}

@JsonProperty("userId")
public String getUserId() {
return userId;
}

@JsonProperty("userId")
public void setUserId(String userId) {
this.userId = userId;
}

@JsonProperty("userName")
public String getUserName() {
return userName;
}

@JsonProperty("userName")
public void setUserName(String userName) {
this.userName = userName;
}

@JsonProperty("emailId")
public String getEmailId() {
return emailId;
}

@JsonProperty("emailId")
public void setEmailId(String emailId) {
this.emailId = emailId;
}

@JsonProperty("firstName")
public String getFirstName() {
return firstName;
}

@JsonProperty("firstName")
public void setFirstName(String firstName) {
this.firstName = firstName;
}

@JsonProperty("lastName")
public String getLastName() {
return lastName;
}

@JsonProperty("lastName")
public void setLastName(String lastName) {
this.lastName = lastName;
}

@JsonProperty("emailVerified")
public Boolean getEmailVerified() {
return emailVerified;
}

@JsonProperty("emailVerified")
public void setEmailVerified(Boolean emailVerified) {
this.emailVerified = emailVerified;
}

@JsonProperty("2FaEnabled")
public Boolean get2FaEnabled() {
return _2FaEnabled;
}

@JsonProperty("2FaEnabled")
public void set2FaEnabled(Boolean _2FaEnabled) {
this._2FaEnabled = _2FaEnabled;
}

@JsonProperty("countryCode")
public String getCountryCode() {
return countryCode;
}

@JsonProperty("countryCode")
public void setCountryCode(String countryCode) {
this.countryCode = countryCode;
}

@JsonProperty("language")
public String getLanguage() {
return language;
}

@JsonProperty("language")
public void setLanguage(String language) {
this.language = language;
}

@JsonProperty("optin")
public Boolean getOptin() {
return optin;
}

@JsonProperty("optin")
public void setOptin(Boolean optin) {
this.optin = optin;
}

@JsonProperty("lastModified")
public String getLastModified() {
return lastModified;
}

@JsonProperty("lastModified")
public void setLastModified(String lastModified) {
this.lastModified = lastModified;
}

@JsonProperty("profileImages")
public ProfileImages getProfileImages() {
return profileImages;
}

@JsonProperty("profileImages")
public void setProfileImages(ProfileImages profileImages) {
this.profileImages = profileImages;
}

@JsonProperty("ldapInfo")
public LdapInfo getLdapInfo() {
return ldapInfo;
}

@JsonProperty("ldapInfo")
public void setLdapInfo(LdapInfo ldapInfo) {
this.ldapInfo = ldapInfo;
}

@JsonProperty("socialUserInfoList")
public List<Object> getSocialUserInfoList() {
return socialUserInfoList;
}

@JsonProperty("socialUserInfoList")
public void setSocialUserInfoList(List<Object> socialUserInfoList) {
this.socialUserInfoList = socialUserInfoList;
}

@JsonProperty("twoFactorAuthType")
public String getTwoFactorAuthType() {
return twoFactorAuthType;
}

@JsonProperty("twoFactorAuthType")
public void setTwoFactorAuthType(String twoFactorAuthType) {
this.twoFactorAuthType = twoFactorAuthType;
}

@JsonProperty("contactMode")
public String getContactMode() {
return contactMode;
}

@JsonProperty("contactMode")
public void setContactMode(String contactMode) {
this.contactMode = contactMode;
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
return new ToStringBuilder(this).append("userId", userId).append("userName", userName).append("emailId", emailId).append("firstName", firstName).append("lastName", lastName).append("emailVerified", emailVerified).append("_2FaEnabled", _2FaEnabled).append("countryCode", countryCode).append("language", language).append("optin", optin).append("lastModified", lastModified).append("profileImages", profileImages).append("ldapInfo", ldapInfo).append("socialUserInfoList", socialUserInfoList).append("twoFactorAuthType", twoFactorAuthType).append("contactMode", contactMode).append("additionalProperties", additionalProperties).toString();
}

@Override
public int hashCode() {
return new HashCodeBuilder().append(socialUserInfoList).append(lastName).append(profileImages).append(optin).append(emailId).append(language).append(userName).append(userId).append(twoFactorAuthType).append(contactMode).append(firstName).append(emailVerified).append(ldapInfo).append(_2FaEnabled).append(countryCode).append(lastModified).append(additionalProperties).toHashCode();
}

@Override
public boolean equals(Object other) {
if (other == this) {
return true;
}
if ((other instanceof UserAtMe) == false) {
return false;
}
UserAtMe rhs = ((UserAtMe) other);
return new EqualsBuilder().append(socialUserInfoList, rhs.socialUserInfoList).append(lastName, rhs.lastName).append(profileImages, rhs.profileImages).append(optin, rhs.optin).append(emailId, rhs.emailId).append(language, rhs.language).append(userName, rhs.userName).append(userId, rhs.userId).append(twoFactorAuthType, rhs.twoFactorAuthType).append(contactMode, rhs.contactMode).append(firstName, rhs.firstName).append(emailVerified, rhs.emailVerified).append(ldapInfo, rhs.ldapInfo).append(_2FaEnabled, rhs._2FaEnabled).append(countryCode, rhs.countryCode).append(lastModified, rhs.lastModified).append(additionalProperties, rhs.additionalProperties).isEquals();
}

}