package io.reactivesw.catalog.producttype.application.model.action;

import io.reactivesw.catalog.producttype.infrastructure.util.ProductTypeActionUtils;
import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.common.model.LocalizedString;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Davis on 16/12/12.
 */
@Getter
@Setter
public class SetAttributeLabel implements UpdateAction {
  /**
   * The Attribute name.
   */
  @NotNull
  @Size(min = 1)
  private String attributeName;

  /**
   * The Label.
   */
  @NotNull
  private LocalizedString label;

  @Override
  public String getActionName() {
    return ProductTypeActionUtils.SET_ATTRIBUTE_DEFINITION_LABEL;
  }
}
