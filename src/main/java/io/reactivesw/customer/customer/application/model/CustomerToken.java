package io.reactivesw.customer.customer.application.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.ZonedDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by umasuo on 16/11/17.
 */
@ApiModel
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

  @Override
  public String toString() {
    return "CustomerToken{" +
            "id='" + id + '\'' +
            ", customerId='" + customerId + '\'' +
            ", createdAt=" + createdAt +
            ", lastModifiedAt=" + lastModifiedAt +
            ", expiresAt=" + expiresAt +
            ", value='" + value + '\'' +
            '}';
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getCustomerId() {
    return customerId;
  }

  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }

  public ZonedDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(ZonedDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public ZonedDateTime getLastModifiedAt() {
    return lastModifiedAt;
  }

  public void setLastModifiedAt(ZonedDateTime lastModifiedAt) {
    this.lastModifiedAt = lastModifiedAt;
  }

  public ZonedDateTime getExpiresAt() {
    return expiresAt;
  }

  public void setExpiresAt(ZonedDateTime expiresAt) {
    this.expiresAt = expiresAt;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
