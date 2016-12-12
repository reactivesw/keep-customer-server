package io.reactivesw.catalog.producttype.application.model.action;

import io.reactivesw.catalog.product.model.attributes.AttributeDefinition;
import io.reactivesw.common.model.UpdateAction;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Davis on 16/12/12.
 */
@Getter
@Setter
public class ChangeAttributeOrder implements UpdateAction {
  /**
   * The Attributes.
   */
  private List<AttributeDefinition> attributes;
}
