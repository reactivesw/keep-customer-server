package io.reactivesw.customer.customer.application.model;

import java.time.ZonedDateTime;
import java.util.List;

import io.reactivesw.common.model.CustomFieldsDraft;
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
}
