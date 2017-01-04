package io.reactivesw.order.cart.application.model.action;

import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.order.cart.infrastructure.enums.TaxMode;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Changes the TaxMode of a cart. When a tax mode is changed from External to Platform or
 * Disabled, all previously set external tax rates will be removed. When changing the tax mode to
 * Platform, line items, custom line items and shipping method require a tax category with a tax
 * rate for the given shipping address.
 * Created by umasuo on 16/12/15.
 */
@Data
public class SetTaxMode implements UpdateAction {

  @NotNull
  TaxMode taxMode;

  @Override
  public String getActionName() {
    return null;
  }
}
