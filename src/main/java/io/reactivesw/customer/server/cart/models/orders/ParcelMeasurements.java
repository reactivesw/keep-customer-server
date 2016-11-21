package io.reactivesw.customer.server.cart.models.orders;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by umasuo on 16/11/17.
 */
@ApiModel(description = "Information regarding the dimensions of a parcel.")
public class ParcelMeasurements {

  @ApiModelProperty(required = true)
  private Float heightInMillimeter;

  @ApiModelProperty(required = true)
  private Float lengthInMillimeter;

  @ApiModelProperty(required = true)
  private Float widthInMillimeter;

  @ApiModelProperty(required = true)
  private Float weightInGram;

  public Float getHeightInMillimeter() {
    return heightInMillimeter;
  }

  public void setHeightInMillimeter(Float heightInMillimeter) {
    this.heightInMillimeter = heightInMillimeter;
  }

  public Float getLengthInMillimeter() {
    return lengthInMillimeter;
  }

  public void setLengthInMillimeter(Float lengthInMillimeter) {
    this.lengthInMillimeter = lengthInMillimeter;
  }

  public Float getWidthInMillimeter() {
    return widthInMillimeter;
  }

  public void setWidthInMillimeter(Float widthInMillimeter) {
    this.widthInMillimeter = widthInMillimeter;
  }

  public Float getWeightInGram() {
    return weightInGram;
  }

  public void setWeightInGram(Float weightInGram) {
    this.weightInGram = weightInGram;
  }
}
