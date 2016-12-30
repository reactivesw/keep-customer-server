package io.reactivesw.catalog.producttype.application.model.action;

import io.reactivesw.catalog.producttype.infrastructure.util.ProductTypeActionUtils;
import io.reactivesw.common.model.PlainEnumValue;
import io.reactivesw.common.model.UpdateAction;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Davis on 16/12/30.
 */
@Getter
@Setter
public class SetPlainEnumValueOrder implements UpdateAction {

  /**
   * The Attribute name.
   */
  @NotNull
  private String attributeName;

  /**
   * The Values.
   */
  @NotNull
  @Size(min = 1)
  private List<PlainEnumValue> values;

  @Override

  public String getActionName() {
    return ProductTypeActionUtils.SET_ENUM_VALUE_ORDER;
  }
}
