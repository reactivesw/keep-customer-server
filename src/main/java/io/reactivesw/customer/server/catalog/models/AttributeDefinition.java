package io.reactivesw.customer.server.catalog.models;

import io.reactivesw.customer.server.common.types.LocalizedString;

/**
 * Created by Davis on 16/11/16.
 */
public class AttributeDefinition {
  /**
   * Describes the type of the attribute.
   */
  private AttributeType type;

  /**
   * he unique name of the attribute used in the API.
   * The name must be between two and 36 characters long
   * and can contain the ASCII letters A to Z in lowercase or uppercase, digits, underscores (_)
   * and the hyphen-minus (-).
   * It is allowed to have attributes with the same name in two or more productTypes.
   * The important constraint is:
   * all fields of the AttributeDefinition need to
   * be the same across all attributes with the same name.
   */
  private String name;

  /**
   * A human-readable label for the attribute.
   */
  private LocalizedString label;

  /**
   * Additional information about the attribute that aids content managers
   * when setting product details.
   */
  private LocalizedString inputTip;

  /**
   * Whether the attribute is required to have a value.
   */
  private Boolean isRequired;

  /**
   * Describes how an attribute or a set of attributes
   * should be validated across all variants of a product.
   */
  private AttributeConstraint attributeConstraint;

}
