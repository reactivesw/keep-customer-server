package io.reactivesw.catalog.product.infrastructure.utils;

import io.reactivesw.catalog.product.application.model.attributes.AttributeConstraint;
import io.reactivesw.catalog.product.application.model.attributes.AttributeDefinition;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Davis on 16/12/20.
 */
public final class AttributeUtils {

  /**
   * private constructor.
   */
  private AttributeUtils() {
  }

  /**
   * Gets attribute name by constraint.
   *
   * @param attributeDefinitions the attribute definitions
   * @param attributeConstraint  the attribute constraint
   * @return the attribute name by constraint
   */
  public static List<String> getAttributeNameByConstraint(List<AttributeDefinition>
                                                              attributeDefinitions,
                                                          AttributeConstraint
                                                              attributeConstraint) {
    return attributeDefinitions.stream().filter(
        attributeDefinition -> {
          return attributeDefinition.getAttributeConstraint().equals(attributeConstraint);
        }
    ).map(attributeDefinition -> {
      return attributeDefinition.getName();
    }).collect(Collectors.toList());
  }
}
