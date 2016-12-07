package io.reactivesw.customer.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.ZonedDateTime;
import java.util.List;

import io.reactivesw.common.model.Address;
import io.reactivesw.common.model.CustomFields;
import io.reactivesw.common.model.Reference;
import io.swagger.annotations.ApiModel;

/**
 * Created by umasuo on 16/11/16.
 */
@ApiModel
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Customer {

  /**
   * customer id, use uuid.
   */
  @JsonProperty
  private String id;

  /**
   * version.
   */
  @JsonProperty
  private Integer version;

  /**
   * The customer number can be used to create a more human-readable (in contrast to ID) identifier
   * for the customer. It should be unique across a project. Once the field was set it cannot be
   * changed anymore.
   */
  @JsonProperty
  private String customerNumber;

  /**
   * create time.
   */
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
  private ZonedDateTime createdAt;

  /**
   * modify time.
   */
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
  private ZonedDateTime lastModifiedAt;

  /**
   * email.
   */
  @JsonProperty
  private String email;

  @JsonProperty
  private String password;

  @JsonProperty
  private String firstName;

  @JsonProperty
  private String lastName;

  @JsonProperty
  private String middleName;

  @JsonProperty
  private String title;

  @JsonProperty
  private ZonedDateTime dateOfBirth;

  @JsonProperty
  private String companyName;

  @JsonProperty
  private String vatId;

  /**
   * The addresses have unique IDs in the addresses list.
   */
  @JsonProperty
  private List<Address> addresses;

  /**
   * The address ID in the addresses list.
   */
  @JsonProperty
  private String defaultShippingAddressId;

  /**
   * The address ID in the addresses list.
   */
  @JsonProperty
  private String defaultBillingAddressId;

  @JsonProperty
  private Boolean isEmailVerified;

  @JsonProperty
  private String externalId;

  @JsonProperty
  private Reference customerGroup;

  @JsonProperty
  private CustomFields custom;

  @JsonProperty
  private String locale;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Integer getVersion() {
    return version;
  }

  public void setVersion(Integer version) {
    this.version = version;
  }

  public String getCustomerNumber() {
    return customerNumber;
  }

  public void setCustomerNumber(String customerNumber) {
    this.customerNumber = customerNumber;
  }

  public ZonedDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(ZonedDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public ZonedDateTime getLastModifiedAt() {
    return lastModifiedAt;
  }

  public void setLastModifiedAt(ZonedDateTime lastModifiedAt) {
    this.lastModifiedAt = lastModifiedAt;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
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

  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public ZonedDateTime getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(ZonedDateTime dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public String getVatId() {
    return vatId;
  }

  public void setVatId(String vatId) {
    this.vatId = vatId;
  }

  public List<Address> getAddresses() {
    return addresses;
  }

  public void setAddresses(List<Address> addresses) {
    this.addresses = addresses;
  }

  public String getDefaultShippingAddressId() {
    return defaultShippingAddressId;
  }

  public void setDefaultShippingAddressId(String defaultShippingAddressId) {
    this.defaultShippingAddressId = defaultShippingAddressId;
  }

  public String getDefaultBillingAddressId() {
    return defaultBillingAddressId;
  }

  public void setDefaultBillingAddressId(String defaultBillingAddressId) {
    this.defaultBillingAddressId = defaultBillingAddressId;
  }

  public Boolean getEmailVerified() {
    return isEmailVerified;
  }

  public void setEmailVerified(Boolean emailVerified) {
    isEmailVerified = emailVerified;
  }

  public String getExternalId() {
    return externalId;
  }

  public void setExternalId(String externalId) {
    this.externalId = externalId;
  }

  public Reference getCustomerGroup() {
    return customerGroup;
  }

  public void setCustomerGroup(Reference customerGroup) {
    this.customerGroup = customerGroup;
  }

  public CustomFields getCustom() {
    return custom;
  }

  public void setCustom(CustomFields custom) {
    this.custom = custom;
  }

  public String getLocale() {
    return locale;
  }

  public void setLocale(String locale) {
    this.locale = locale;
  }
}
