package io.reactivesw.common.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by umasuo on 16/11/21.
 */
@ApiModel
public class UpdateAction {

  /**
   * The Action.
   */
  @ApiModelProperty(required = true)
  private String action;

  /**
   * Gets action.
   *
   * @return the action
   */
  public String getAction() {
    return action;
  }

  /**
   * Sets action.
   *
   * @param action the action
   */
  public void setAction(String action) {
    this.action = action;
  }
}
