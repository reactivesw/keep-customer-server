package io.reactivesw.customer.server.customer.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

import io.reactivesw.customer.server.common.types.Address;
import io.reactivesw.customer.server.common.types.CustomFields;
import io.reactivesw.customer.server.common.types.Reference;
import io.swagger.annotations.ApiModel;

/**
 * Created by umasuo on 16/11/16.
 */
@ApiModel
public class Customer {

  private String id;
  private Integer version;
  private String customerNumber;
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
  private ZonedDateTime createdAt;
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
  private ZonedDateTime lastModifiedAt;
  private String email;
  private String password;
  private String firstName;
  private String lastName;
  private String middleName;
  private String title;
  private Date dateOfBirth;
  private String companyName;
  private String vatId;
  private List<Address> addresses;
  private String defaultShippingAddressId;
  private String defaultBillingAddressId;
  private Boolean isEmailVerified;
  private String externalId;
  private Reference customerGroup;
  private CustomFields custom;
  private String locale;

  @Override
  public String toString() {
    return "Customer{" +
            "id='" + id + '\'' +
            ", version=" + version +
            ", customerNumber='" + customerNumber + '\'' +
            ", createdAt=" + createdAt +
            ", lastModifiedAt=" + lastModifiedAt +
            ", email='" + email + '\'' +
            ", password='" + password + '\'' +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", middleName='" + middleName + '\'' +
            ", title='" + title + '\'' +
            ", dateOfBirth=" + dateOfBirth +
            ", companyName='" + companyName + '\'' +
            ", vatId='" + vatId + '\'' +
            ", addresses=" + addresses +
            ", defaultShippingAddressId='" + defaultShippingAddressId + '\'' +
            ", defaultBillingAddressId='" + defaultBillingAddressId + '\'' +
            ", isEmailVerified=" + isEmailVerified +
            ", externalId='" + externalId + '\'' +
            ", customerGroup=" + customerGroup +
            ", custom=" + custom +
            ", locale='" + locale + '\'' +
            '}';
  }

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

  public Date getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(Date dateOfBirth) {
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

  public boolean isEmailVerified() {
    return isEmailVerified;
  }

  public void setEmailVerified(boolean emailVerified) {
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
