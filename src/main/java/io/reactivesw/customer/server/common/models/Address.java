package io.reactivesw.customer.server.common.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by umasuo on 16/11/16.
 */
@ApiModel
@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {

  @ApiModelProperty(value = "address id, use uuid.", required = false)
  @JsonProperty
  private String id;

  @ApiModelProperty(value = "address title.", required = false)
  @JsonProperty
  private String title;

  @ApiModelProperty(value = "salutation.", required = false)
  @JsonProperty
  private String salutation;

  @ApiModelProperty(value = "First name of the receiver.", required = false)
  @JsonProperty
  private String firstName;

  @ApiModelProperty(value = "Last name of the receiver.", required = false)
  @JsonProperty
  private String lastName;

  @ApiModelProperty(value = "Street name.", required = false)
  @JsonProperty
  private String streetName;

  @ApiModelProperty(value = "Street number.", required = false)
  @JsonProperty
  private String streetNumber;

  @ApiModelProperty(value = "Additional Street Info.", required = false)
  @JsonProperty
  private String additionalStreetInfo;

  @ApiModelProperty(value = "Postal Code.", required = false)
  @JsonProperty
  private String postalCode;

  @ApiModelProperty(required = false)
  @JsonProperty
  private String city;

  @ApiModelProperty(required = false)
  @JsonProperty
  private String region;

  @ApiModelProperty(required = false)
  @JsonProperty
  private String state;

  @ApiModelProperty(required = false)
  @JsonProperty
  private String country;

  @ApiModelProperty(required = false)
  @JsonProperty
  private String company;

  @ApiModelProperty(required = false)
  @JsonProperty
  private String department;

  @ApiModelProperty(required = false)
  @JsonProperty
  private String building;

  @ApiModelProperty(required = false)
  @JsonProperty
  private String apartment;

  @ApiModelProperty(required = false)
  @JsonProperty
  private String pOBox;

  @ApiModelProperty(required = false)
  @JsonProperty
  private String phone;

  @ApiModelProperty(required = false)
  @JsonProperty
  private String mobile;

  @ApiModelProperty(value = "Email of the receiver", required = false)
  @JsonProperty
  private String email;

  @ApiModelProperty(required = false)
  @JsonProperty
  private String fax;

  @ApiModelProperty(value = "Additional Address Info", required = false)
  @JsonProperty
  private String additionalAddressInfo;

  @ApiModelProperty(value = "External Id", required = false)
  @JsonProperty
  private String externalId;

  @Override
  public String toString() {
    return "Address{" +
            "id='" + id + '\'' +
            ", title='" + title + '\'' +
            ", salutation='" + salutation + '\'' +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", streetName='" + streetName + '\'' +
            ", streetNumber='" + streetNumber + '\'' +
            ", additionalStreetInfo='" + additionalStreetInfo + '\'' +
            ", postalCode='" + postalCode + '\'' +
            ", city='" + city + '\'' +
            ", region='" + region + '\'' +
            ", state='" + state + '\'' +
            ", country='" + country + '\'' +
            ", company='" + company + '\'' +
            ", department='" + department + '\'' +
            ", building='" + building + '\'' +
            ", apartment='" + apartment + '\'' +
            ", pOBox='" + pOBox + '\'' +
            ", phone='" + phone + '\'' +
            ", mobile='" + mobile + '\'' +
            ", email='" + email + '\'' +
            ", fax='" + fax + '\'' +
            ", additionalAddressInfo='" + additionalAddressInfo + '\'' +
            ", externalId='" + externalId + '\'' +
            '}';
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getSalutation() {
    return salutation;
  }

  public void setSalutation(String salutation) {
    this.salutation = salutation;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getStreetName() {
    return streetName;
  }

  public void setStreetName(String streetName) {
    this.streetName = streetName;
  }

  public String getStreetNumber() {
    return streetNumber;
  }

  public void setStreetNumber(String streetNumber) {
    this.streetNumber = streetNumber;
  }

  public String getAdditionalStreetInfo() {
    return additionalStreetInfo;
  }

  public void setAdditionalStreetInfo(String additionalStreetInfo) {
    this.additionalStreetInfo = additionalStreetInfo;
  }

  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public String getBuilding() {
    return building;
  }

  public void setBuilding(String building) {
    this.building = building;
  }

  public String getApartment() {
    return apartment;
  }

  public void setApartment(String apartment) {
    this.apartment = apartment;
  }

  public String getpOBox() {
    return pOBox;
  }

  public void setpOBox(String pOBox) {
    this.pOBox = pOBox;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getFax() {
    return fax;
  }

  public void setFax(String fax) {
    this.fax = fax;
  }

  public String getAdditionalAddressInfo() {
    return additionalAddressInfo;
  }

  public void setAdditionalAddressInfo(String additionalAddressInfo) {
    this.additionalAddressInfo = additionalAddressInfo;
  }

  public String getExternalId() {
    return externalId;
  }

  public void setExternalId(String externalId) {
    this.externalId = externalId;
  }
}
