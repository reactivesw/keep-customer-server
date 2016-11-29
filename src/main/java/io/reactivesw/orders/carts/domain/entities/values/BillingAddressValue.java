package io.reactivesw.orders.carts.domain.entities.values;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.reactivesw.common.entities.BaseIdEntity;

/**
 * Created by umasuo on 16/11/28.
 */
@Entity
@Table(name = "orders_carts_billing_address")
public class BillingAddressValue extends BaseIdEntity {

  /**
   * title.
   */
  @Column
  private String title;

  /**
   * salutation.
   */
  @Column
  private String salutation;

  /**
   * first name.
   */
  @Column(name = "first_name")
  private String firstName;

  /**
   * last name.
   */
  @Column(name = "last_name")
  private String lastName;

  /**
   * street name.
   */
  @Column(name = "street_name")
  private String streetName;

  /**
   * street number.
   */
  @Column(name = "street_number")
  private String streetNumber;

  /**
   * additional street info.
   */
  @Column(name = "additional_street_info")
  private String additionalStreetInfo;

  /**
   * postal code.
   */
  @Column(name = "postal_code")
  private String postalCode;

  /**
   * city.
   */
  @Column
  private String city;

  /**
   * region.
   */
  @Column
  private String region;

  /**
   * state.
   */
  @Column
  private String state;

  /**
   * country.
   */
  @Column
  private String country;

  /**
   * coompany.
   */
  @Column
  private String company;

  /**
   * department.
   */
  @Column
  private String department;

  /**
   * building.
   */
  @Column
  private String building;

  /**
   * apartment.
   */
  @Column
  private String apartment;

  /**
   * p0box.
   */
  @Column(name = "p0box")
  private String box;

  /**
   * phone.
   */
  @Column
  private String phone;

  /**
   * mobile.
   */
  @Column
  private String mobile;

  /**
   * email.
   */
  @Column
  private String email;

  /**
   * fax.
   */
  @Column
  private String fax;

  /**
   * additional address info.
   */
  @Column(name = "additional_address_info")
  private String additionalAddressInfo;

  /**
   * external id.
   */
  @Column(name = "external_id")
  private String externalId;

  /**
   * to string method.
   * @return
   */
  @Override
  public String toString() {
    return "ShippingAddressValue{" +
            "title='" + title + '\'' +
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
            ", box='" + box + '\'' +
            ", phone='" + phone + '\'' +
            ", mobile='" + mobile + '\'' +
            ", email='" + email + '\'' +
            ", fax='" + fax + '\'' +
            ", additionalAddressInfo='" + additionalAddressInfo + '\'' +
            ", externalId='" + externalId + '\'' +
            '}';
  }

  /**
   * Gets title.
   *
   * @return the title
   */
  public String getTitle() {
    return title;
  }

  /**
   * Sets title.
   *
   * @param title the title
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * Gets salutation.
   *
   * @return the salutation
   */
  public String getSalutation() {
    return salutation;
  }

  /**
   * Sets salutation.
   *
   * @param salutation the salutation
   */
  public void setSalutation(String salutation) {
    this.salutation = salutation;
  }

  /**
   * Gets first name.
   *
   * @return the first name
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Sets first name.
   *
   * @param firstName the first name
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * Gets last name.
   *
   * @return the last name
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Sets last name.
   *
   * @param lastName the last name
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * Gets street name.
   *
   * @return the street name
   */
  public String getStreetName() {
    return streetName;
  }

  /**
   * Sets street name.
   *
   * @param streetName the street name
   */
  public void setStreetName(String streetName) {
    this.streetName = streetName;
  }

  /**
   * Gets street number.
   *
   * @return the street number
   */
  public String getStreetNumber() {
    return streetNumber;
  }

  /**
   * Sets street number.
   *
   * @param streetNumber the street number
   */
  public void setStreetNumber(String streetNumber) {
    this.streetNumber = streetNumber;
  }

  /**
   * Gets additional street info.
   *
   * @return the additional street info
   */
  public String getAdditionalStreetInfo() {
    return additionalStreetInfo;
  }

  /**
   * Sets additional street info.
   *
   * @param additionalStreetInfo the additional street info
   */
  public void setAdditionalStreetInfo(String additionalStreetInfo) {
    this.additionalStreetInfo = additionalStreetInfo;
  }

  /**
   * Gets postal code.
   *
   * @return the postal code
   */
  public String getPostalCode() {
    return postalCode;
  }

  /**
   * Sets postal code.
   *
   * @param postalCode the postal code
   */
  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  /**
   * Gets city.
   *
   * @return the city
   */
  public String getCity() {
    return city;
  }

  /**
   * Sets city.
   *
   * @param city the city
   */
  public void setCity(String city) {
    this.city = city;
  }

  /**
   * Gets region.
   *
   * @return the region
   */
  public String getRegion() {
    return region;
  }

  /**
   * Sets region.
   *
   * @param region the region
   */
  public void setRegion(String region) {
    this.region = region;
  }

  /**
   * Gets state.
   *
   * @return the state
   */
  public String getState() {
    return state;
  }

  /**
   * Sets state.
   *
   * @param state the state
   */
  public void setState(String state) {
    this.state = state;
  }

  /**
   * Gets country.
   *
   * @return the country
   */
  public String getCountry() {
    return country;
  }

  /**
   * Sets country.
   *
   * @param country the country
   */
  public void setCountry(String country) {
    this.country = country;
  }

  /**
   * Gets company.
   *
   * @return the company
   */
  public String getCompany() {
    return company;
  }

  /**
   * Sets company.
   *
   * @param company the company
   */
  public void setCompany(String company) {
    this.company = company;
  }

  /**
   * Gets department.
   *
   * @return the department
   */
  public String getDepartment() {
    return department;
  }

  /**
   * Sets department.
   *
   * @param department the department
   */
  public void setDepartment(String department) {
    this.department = department;
  }

  /**
   * Gets building.
   *
   * @return the building
   */
  public String getBuilding() {
    return building;
  }

  /**
   * Sets building.
   *
   * @param building the building
   */
  public void setBuilding(String building) {
    this.building = building;
  }

  /**
   * Gets apartment.
   *
   * @return the apartment
   */
  public String getApartment() {
    return apartment;
  }

  /**
   * Sets apartment.
   *
   * @param apartment the apartment
   */
  public void setApartment(String apartment) {
    this.apartment = apartment;
  }

  /**
   * Gets box.
   *
   * @return the box
   */
  public String getBox() {
    return box;
  }

  /**
   * Sets box.
   *
   * @param box the box
   */
  public void setBox(String box) {
    this.box = box;
  }

  /**
   * Gets phone.
   *
   * @return the phone
   */
  public String getPhone() {
    return phone;
  }

  /**
   * Sets phone.
   *
   * @param phone the phone
   */
  public void setPhone(String phone) {
    this.phone = phone;
  }

  /**
   * Gets mobile.
   *
   * @return the mobile
   */
  public String getMobile() {
    return mobile;
  }

  /**
   * Sets mobile.
   *
   * @param mobile the mobile
   */
  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  /**
   * Gets email.
   *
   * @return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * Sets email.
   *
   * @param email the email
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Gets fax.
   *
   * @return the fax
   */
  public String getFax() {
    return fax;
  }

  /**
   * Sets fax.
   *
   * @param fax the fax
   */
  public void setFax(String fax) {
    this.fax = fax;
  }

  /**
   * Gets additional address info.
   *
   * @return the additional address info
   */
  public String getAdditionalAddressInfo() {
    return additionalAddressInfo;
  }

  /**
   * Sets additional address info.
   *
   * @param additionalAddressInfo the additional address info
   */
  public void setAdditionalAddressInfo(String additionalAddressInfo) {
    this.additionalAddressInfo = additionalAddressInfo;
  }

  /**
   * Gets external id.
   *
   * @return the external id
   */
  public String getExternalId() {
    return externalId;
  }

  /**
   * Sets external id.
   *
   * @param externalId the external id
   */
  public void setExternalId(String externalId) {
    this.externalId = externalId;
  }
}
