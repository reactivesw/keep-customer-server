package io.reactivesw.customer.customer.application.model;

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
import lombok.Data;

/**
 * Created by umasuo on 16/11/16.
 */
@ApiModel
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
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
}
