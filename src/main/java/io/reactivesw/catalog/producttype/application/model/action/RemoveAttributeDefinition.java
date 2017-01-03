package io.reactivesw.catalog.producttype.application.model.action;

import io.reactivesw.catalog.producttype.infrastructure.util.ProductTypeActionUtils;
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
public class RemoveAttributeDefinition implements UpdateAction {
  /**
   * The Name.
   */
  @NotNull
  @Size(min = 1)
  private String name;

  @Override
  public String getActionName() {
    return ProductTypeActionUtils.REMOVE_ATTRIBUTE_DEFINITION;
  }
}
