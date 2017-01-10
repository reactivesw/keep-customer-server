package io.reactivesw.order.order.domain.entity.value;

import io.reactivesw.common.entity.BaseIdEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by umasuo on 16/11/28.
 */
@Entity
@Table(name = "order_billing_address")
@Data
@EqualsAndHashCode(callSuper = false)
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

}
