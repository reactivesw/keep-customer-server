package io.reactivesw.customer.customer.application.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Id;

/**
 * Created by umasuo on 16/11/16.
 */
@ApiModel
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Address {

  @ApiModelProperty(value = "address id, use uuid.")
  @JsonProperty
  @Id
  private String id;

  @ApiModelProperty(value = "address title.")
  @JsonProperty
  private String title;

  @ApiModelProperty(value = "salutation.")
  @JsonProperty
  private String salutation;

  @ApiModelProperty(value = "First name of the receiver.")
  @JsonProperty
  private String firstName;

  @ApiModelProperty(value = "Last name of the receiver.")
  @JsonProperty
  private String lastName;

  @ApiModelProperty(value = "Street name.")
  @JsonProperty
  private String streetName;

  @ApiModelProperty(value = "Street number.")
  @JsonProperty
  private String streetNumber;

  @ApiModelProperty(value = "Additional Street Info.")
  @JsonProperty
  private String additionalStreetInfo;

  @ApiModelProperty(value = "Postal Code.")
  @JsonProperty
  private String postalCode;

  @ApiModelProperty
  @JsonProperty
  private String city;

  @ApiModelProperty
  @JsonProperty
  private String region;

  @ApiModelProperty
  @JsonProperty
  private String state;

  @ApiModelProperty
  @JsonProperty
  private String country;

  @ApiModelProperty
  @JsonProperty
  private String company;

  @ApiModelProperty
  @JsonProperty
  private String department;

  @ApiModelProperty
  @JsonProperty
  private String building;

  @ApiModelProperty
  @JsonProperty
  private String apartment;

  @ApiModelProperty
  @JsonProperty
  private String pOBox;

  @ApiModelProperty
  @JsonProperty
  private String phone;

  @ApiModelProperty
  @JsonProperty
  private String mobile;

  @ApiModelProperty(value = "Email of the receiver")
  @JsonProperty
  private String email;

  @ApiModelProperty
  @JsonProperty
  private String fax;

  @ApiModelProperty(value = "Additional Address Info")
  @JsonProperty
  private String additionalAddressInfo;

  @ApiModelProperty(value = "External Id")
  @JsonProperty
  private String externalId;
}
