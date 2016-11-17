package io.reactivesw.customer.server.customer.models;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

import io.reactivesw.customer.server.common.types.Address;

/**
 * Created by BruceLiu on 16/11/16.
 */
public class MyCustomerDraft {

  private String email;
  private String password;
  private String firstName;
  private String lastName;
  private String middleName;
  private String title;
  private ZonedDateTime dateOfBirth;
  private String vatId;
  private List<Address> addresses;
  private Integer defaultBillingAddress;
  private Integer defaultShippingAddress;
  private CustomFieldsDraft custom;
  private CustomFieldsDraft locale;

  @Override
  public String toString() {
    return "MyCustomerDraft{" +
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
