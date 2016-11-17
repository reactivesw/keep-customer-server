package io.reactivesw.customer.server.catalog.entities;

import io.reactivesw.customer.server.common.types.LocalizedString;

/**
 * Created by Davis on 16/11/16.
 */
public class AttributeDefinition {
  AttributeType type;
  String name;
  LocalizedString label;
  LocalizedString inputTip;
  Boolean isRequired;
  AttributeConstraint attributeConstraint;

}
