package io.reactivesw.order.cartdiscount.application.model.action;

import io.reactivesw.common.model.UpdateAction;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * Created by umasuo on 16/12/21.
 */
@Data
@ApiModel
public class SetActive implements UpdateAction {

  /**
   * is active.
   */
  private Boolean active;

  @Override
  public String getActionName() {
    return null;
  }
}
