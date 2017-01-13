package io.reactivesw.customer.customer.domain.entity;

import io.reactivesw.common.entity.BaseAllEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.ZonedDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Created by umasuo on 16/12/26.
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "customer")
public class CustomerEntity extends BaseAllEntity {

  /**
   * The customer number can be used to create a more human-readable (in contrast to ID) identifier
   * for the customer. It should be unique across a merchant. Once the field was set it cannot be
   * changed anymore.
   */
  @Column(name = "customer_name", unique = true)
  private String customerName;

  /**
   * version.
   */
  @Version
  @Column(name = "version")
  private Integer version;

  /**
   * email.
   */
  @Column(name = "email", unique = true)
  private String email;

  /**
   * password.
   */
  @Column(name = "password")
  private String password;

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
   * middle name.
   */
  @Column(name = "middle_name")
  private String middleName;

  /**
   * title.
   */
  @Column(name = "title")
  private String title;

  /**
   * date of birth.
   */
  @Column(name = "date_of_birth")
  private ZonedDateTime dateOfBirth;

  /**
   * company name.
   */
  @Column(name = "company_name")
  private String companyName;

  /**
   * vatId.
   */
  @Column(name = "vatId")
  private String vatId;

  /**
   * The addresses have unique IDs in the addresses list.
   */
  @OneToMany
  private Set<AddressValue> addresses;

  /**
   * The address ID in the addresses list.
   */
  @Column(name = "default_shipping_address_id")
  private String defaultShippingAddressId;

  /**
   * The address ID in the addresses list.
   */
  @Column(name = "default_billing_address_id")
  private String defaultBillingAddressId;

  /**
   * is email verified.
   */
  @Column(name = "is_email_verified")
  private Boolean isEmailVerified;

  /**
   * external id.
   */
  @Column(name = "external_id")
  private String externalId;

  /**
   * customer group id.
   */
  @Column(name = "customer_group_id")
  private String customerGroupId;

  /**
   * locale.
   */
  @Column(name = "locale")
  private String locale;
}
