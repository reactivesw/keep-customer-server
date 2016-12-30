package io.reactivesw.catalog.producttype.application.model.action;

import io.reactivesw.catalog.producttype.infrastructure.util.ProductTypeActionUtils;
import io.reactivesw.common.model.LocalizedEnumValue;
import io.reactivesw.common.model.UpdateAction;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Davis on 16/12/30.
 */
@Getter
@Setter
public class SetLocalizedEnumValueLabel implements UpdateAction {

  /**
   * The Attribute name.
   */
  private String attributeName;

  /**
   * The New value.
   */
  private LocalizedEnumValue newValue;

  @Override
  public String getActionName() {
    return ProductTypeActionUtils.SET_LOCALIZED_ENUM_VALUE_LABEL;
  }
}
