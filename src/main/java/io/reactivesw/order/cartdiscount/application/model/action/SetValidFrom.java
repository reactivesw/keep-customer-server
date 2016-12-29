package io.reactivesw.order.cartdiscount.application.model.action;

import io.reactivesw.common.model.UpdateAction;
import lombok.Data;

import java.time.ZonedDateTime;

/**
 * Created by umasuo on 16/12/22.
 */
@Data
public class SetValidFrom implements UpdateAction {

  private ZonedDateTime validFrom;

  @Override
  public String getActionName() {
    return null;
  }
}
