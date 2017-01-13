package io.reactivesw.merchant.application.model.action;

import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.merchant.infrastructure.util.InternationalActionUtils;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Davis on 17/1/9.
 */
@Getter
@Setter
public class SetDefaultCurrencyAction implements UpdateAction {

  /**
   * default currency code.
   */
  @NotNull
  @Size(min = 1)
  private String currencyCode;

  @Override
  public String getActionName() {
    return InternationalActionUtils.SET_DEFAULT_CURRENCY;
  }
}
