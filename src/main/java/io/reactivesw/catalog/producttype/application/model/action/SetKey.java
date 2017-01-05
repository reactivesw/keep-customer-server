package io.reactivesw.catalog.producttype.application.model.action;

import io.reactivesw.catalog.producttype.infrastructure.util.ProductTypeActionUtils;
import io.reactivesw.common.model.UpdateAction;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Davis on 16/12/8.
 */
@Getter
@Setter
public class SetKey implements UpdateAction {
  /**
   * The Key.
   */
  private String key;

  @Override
  public String getActionName() {
    return ProductTypeActionUtils.SET_KEY;
  }
}
