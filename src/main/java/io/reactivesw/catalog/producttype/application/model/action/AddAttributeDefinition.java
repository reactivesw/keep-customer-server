package io.reactivesw.catalog.producttype.application.model.action;

import io.reactivesw.catalog.product.application.model.AttributeDefinitionDraft;
import io.reactivesw.catalog.producttype.infrastructure.util.ProductTypeActionUtils;
import io.reactivesw.common.model.UpdateAction;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Davis on 16/12/8.
 */
@Getter
@Setter
public class AddAttributeDefinition implements UpdateAction {
  /**
   * The Attribute.
   */
  private AttributeDefinitionDraft attribute;

  @Override
  public String getActionName() {
    return ProductTypeActionUtils.ADD_ATTRIBUTE_DEFINITION;
  }
}
