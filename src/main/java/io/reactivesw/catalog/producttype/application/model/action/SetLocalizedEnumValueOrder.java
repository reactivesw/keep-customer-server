package io.reactivesw.catalog.producttype.application.model.action;

import io.reactivesw.catalog.producttype.infrastructure.util.ProductTypeActionUtils;
import io.reactivesw.common.model.LocalizedEnumValue;
import io.reactivesw.common.model.UpdateAction;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by Davis on 16/12/30.
 */
@Getter
@Setter
public class SetLocalizedEnumValueOrder implements UpdateAction {

  /**
   * The Attribute name.
   */
  private String attributeName;

  /**
   * The Values.
   */
  private List<LocalizedEnumValue> values;

  @Override
  public String getActionName() {
    return ProductTypeActionUtils.SET_LOCALIZED_ENUM_VALUE_ORDER;
  }
}
