package io.reactivesw.order.cartdiscount.application.model.action;

import io.reactivesw.common.model.UpdateAction;
import lombok.Data;

import java.time.ZonedDateTime;

/**
 * Created by umasuo on 16/12/22.
 */
@Data
public class SetValidUntil implements UpdateAction {

  private ZonedDateTime validUntil;

  @Override
  public String getActionName() {
    return null;
  }
}
