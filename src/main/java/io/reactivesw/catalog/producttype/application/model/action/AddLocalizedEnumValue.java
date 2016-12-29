package io.reactivesw.catalog.producttype.application.model.action;

import io.reactivesw.common.model.LocalizedEnumValue;
import io.reactivesw.common.model.UpdateAction;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Davis on 16/12/12.
 */
@Getter
@Setter
public class AddLocalizedEnumValue implements UpdateAction {
  /**
   * The Attribute name.
   */
  private String attributeName;

  /**
   * The Value.
   */
  private LocalizedEnumValue value;

  @Override
  public String getActionName() {
    return null;
  }
}
