package io.reactivesw.customer.server.customer.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.ZonedDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * CustomerGroup fields that can be used in query predicates: name.
 * Created by umasuo on 16/11/17.
 */
@ApiModel(description = "CustomerGroup fields that can be used in query predicates: name.")
public class CustomerGroup {

  @ApiModelProperty(value = "The unique ID of the customer.", required = true)
  private String id;

  @ApiModelProperty(value = "The current version of the customer.", required = true)
  private Integer version;

  @ApiModelProperty(required = true)
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
  private ZonedDateTime createdAt;

  @ApiModelProperty(required = true)
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
  private ZonedDateTime lastModifiedAt;

  @ApiModelProperty(required = true)
  private String name;


}
