package io.reactivesw.customer.server.customer.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

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
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Customer {

  @JsonProperty
  private String id;
  @JsonProperty
  private Integer version;
  @JsonProperty
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
  @JsonProperty
  private List<Address> addresses;
  @JsonProperty
  private String defaultShippingAddressId;
  private String defaultBillingAddressId;
  private Boolean isEmailVerified;
  private String externalId;
  private Reference customerGroup;
  private CustomFields custom;
  private String locale;
}
