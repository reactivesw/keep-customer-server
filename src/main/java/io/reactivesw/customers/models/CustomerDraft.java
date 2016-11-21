package io.reactivesw.customers.models;

import java.time.ZonedDateTime;
import java.util.List;

import io.reactivesw.common.models.Address;
import io.reactivesw.types.models.CustomFieldsDraft;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * this is the MyCustomerDraft.
 * Created by BruceLiu on 16/11/16.
 */
@ApiModel
public class CustomerDraft {

  @ApiModelProperty(required = true)
  private String email;

  @ApiModelProperty(required = true)
  private String password;

  @ApiModelProperty(required = false)
  private String firstName;

  @ApiModelProperty(required = false)
  private String lastName;

  @ApiModelProperty(required = false)
  private String middleName;

  @ApiModelProperty(required = false)
  private String title;

  @ApiModelProperty(required = false)
  private ZonedDateTime dateOfBirth;

  @ApiModelProperty(required = false)
  private String vatId;

  @ApiModelProperty(required = false)
  private List<Address> addresses;

  @ApiModelProperty(required = false)
  private Integer defaultBillingAddress;

  @ApiModelProperty(required = false)
  private Integer defaultShippingAddress;

  @ApiModelProperty(required = false)
  private CustomFieldsDraft custom;

  @ApiModelProperty(required = false)
  private CustomFieldsDraft locale;

  @Override
  public String toString() {
    return "CustomerDraft{" +
            "email='" + email + '\'' +
            ", password='" + password + '\'' +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", middleName='" + middleName + '\'' +
            ", title='" + title + '\'' +
            ", dateOfBirth=" + dateOfBirth +
            ", vatId='" + vatId + '\'' +
            ", addresses=" + addresses +
            ", defaultBillingAddress=" + defaultBillingAddress +
            ", defaultShippingAddress=" + defaultShippingAddress +
            ", custom=" + custom +
            ", locale=" + locale +
            '}';
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

  public Integer getDefaultBillingAddress() {
    return defaultBillingAddress;
  }

  public void setDefaultBillingAddress(Integer defaultBillingAddress) {
    this.defaultBillingAddress = defaultBillingAddress;
  }

  public Integer getDefaultShippingAddress() {
    return defaultShippingAddress;
  }

  public void setDefaultShippingAddress(Integer defaultShippingAddress) {
    this.defaultShippingAddress = defaultShippingAddress;
  }

  public CustomFieldsDraft getCustom() {
    return custom;
  }

  public void setCustom(CustomFieldsDraft custom) {
    this.custom = custom;
  }

  public CustomFieldsDraft getLocale() {
    return locale;
  }

  public void setLocale(CustomFieldsDraft locale) {
    this.locale = locale;
  }
}
