package io.reactivesw.orders.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.ZonedDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by umasuo on 16/11/17.
 */
@ApiModel(description = "A parcel stores the information about the appearance and the movement of a parcel")
public class Parcel {

  @ApiModelProperty(value = "Unique id of the parcel", required = true)
  private String id;

  @ApiModelProperty(required = true)
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
  private ZonedDateTime createdAt;

  @ApiModelProperty(required = false)
  private ParcelMeasurements measurements;

  @ApiModelProperty(required = false)
  private TrackingData trackingData;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ZonedDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(ZonedDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public ParcelMeasurements getMeasurements() {
    return measurements;
  }

  public void setMeasurements(ParcelMeasurements measurements) {
    this.measurements = measurements;
  }

  public TrackingData getTrackingData() {
    return trackingData;
  }

  public void setTrackingData(TrackingData trackingData) {
    this.trackingData = trackingData;
  }
}
