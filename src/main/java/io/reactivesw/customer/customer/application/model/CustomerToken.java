package io.reactivesw.customer.customer.application.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.ZonedDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by umasuo on 16/11/17.
 */
@ApiModel
@Data
public class CustomerToken {

  @ApiModelProperty(required = true)
  private String id;

  @ApiModelProperty(required = true)
  private String customerId;

  @ApiModelProperty(required = true)
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
  private ZonedDateTime createdAt;

  @ApiModelProperty(required = true)
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
  private ZonedDateTime lastModifiedAt;

  @ApiModelProperty(required = true)
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
  private ZonedDateTime expiresAt;

  @ApiModelProperty(required = true)
  private String value;

}
