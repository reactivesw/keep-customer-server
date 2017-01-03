package io.reactivesw.catalog.producttype.application.model.action;

import io.reactivesw.catalog.producttype.infrastructure.util.ProductTypeActionUtils;
import io.reactivesw.common.model.PlainEnumValue;
import io.reactivesw.common.model.UpdateAction;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Davis on 16/12/12.
 */
@Getter
@Setter
public class AddPlainEnumValue implements UpdateAction {
  /**
   * The Attribute name.
   */
  @NotNull
  @Size(min = 1)
  private String attributeName;

  /**
   * The Value.
   */
  private PlainEnumValue value;

  @Override
  public String getActionName() {
    return ProductTypeActionUtils.ADD_PLAIN_ENUM_VALUE;
  }
}
