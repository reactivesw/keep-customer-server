package io.reactivesw.catalog.product.infrastructure.validator;

import io.reactivesw.catalog.product.application.model.ProductDraft;
import io.reactivesw.catalog.product.application.model.attributes.Attribute;
import io.reactivesw.catalog.product.application.model.attributes.AttributeConstraint;
import io.reactivesw.catalog.product.application.model.attributes.AttributeDefinition;
import io.reactivesw.catalog.product.infrastructure.utils.AttributeUtils;
import io.reactivesw.common.exception.ParametersException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Davis on 16/12/20.
 */
public final class SameForAllAttributeValidator {
  /**
   * log.
   */
  private static final Logger LOG = LoggerFactory.getLogger(SameForAllAttributeValidator.class);

  /**
   * private constructor.
   */
  private SameForAllAttributeValidator() {
  }

  /**
   * Validate same for all attribute.
   *
   * @param attributeDefinitions the attribute definitions
   * @param productDraft         the product draft
   */
  public static void validate(List<AttributeDefinition> attributeDefinitions,
                              ProductDraft productDraft) {
    List<String> attributeNames = AttributeUtils.getAttributeNameByConstraint(attributeDefinitions,
        AttributeConstraint.SameForAll);

    attributeNames.forEach(
        attributeName -> {
          validate(attributeName, productDraft);
        }
    );
  }

  /**
   * Validate same for all attribute.
   *
   * @param attributeName the attribute name
   * @param productDraft  the product draft
   */
  private static void validate(String attributeName, ProductDraft productDraft) {
    List<Attribute> masterAttributes = productDraft.getMasterVariant().getAttributes();
    // TODO: 16/12/19 attributeValue should be JsonNode type
    String attributeValue = "";
    if (masterAttributes != null) {
      List<String> masterAttributeValue = masterAttributes.stream().filter(
          attribute -> attribute.getName().equals(attributeName))
          .map(
              attribute -> {
                return attribute.getValue().toString();
              }
          ).collect(Collectors.toList());
      if (masterAttributeValue != null && !masterAttributeValue.isEmpty()) {
        attributeValue = masterAttributeValue.get(0);
      }
    }

    String finalAttributeValue = attributeValue;
    if (productDraft.getVariants() != null) {
      productDraft.getVariants().stream()
          .forEach(productVariantDraft -> {
            productVariantDraft.getAttributes().forEach(
                attribute -> {
                  if (attribute.getName().equals(attributeName)
                      && !attribute.getValue().toString().equals(finalAttributeValue)) {
                    LOG.debug("same for all attribute should have same value");
                    throw new ParametersException(
                        "same for all attribute should have same value");
                  }
                }
            );
          });
    }
  }
}
