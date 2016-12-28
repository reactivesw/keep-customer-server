package io.reactivesw.catalog.product.infrastructure.validator;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import io.reactivesw.catalog.product.application.model.ProductDraft;
import io.reactivesw.catalog.product.application.model.attributes.AttributeConstraint;
import io.reactivesw.catalog.product.application.model.attributes.AttributeDefinition;
import io.reactivesw.catalog.product.infrastructure.util.AttributeUtils;
import io.reactivesw.common.exception.ParametersException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Set;

/**
 * Created by Davis on 16/12/20.
 */
public final class UniqueAttributeValidator {
  /**
   * log.
   */
  private static final Logger LOG = LoggerFactory.getLogger(UniqueAttributeValidator.class);

  /**
   * private constructor.
   */
  private UniqueAttributeValidator() {
  }

  /**
   * Validate product unique attribuate.
   *
   * @param attributeDefinitions the attribute definitions
   * @param productDraft         the product draft
   */
  public static void validate(List<AttributeDefinition>
                                  attributeDefinitions,
                              ProductDraft productDraft) {
    List<String> uniqueAttributes = AttributeUtils.getAttributeNameByConstraint(
        attributeDefinitions,
        AttributeConstraint.Unique);

    uniqueAttributes.stream().forEach(
        uniqueAttribute -> {
          validateUniqueAttribute(uniqueAttribute, productDraft);
        }
    );
  }

  /**
   * Validate unique attribute.
   *
   * @param attributeName the attribute name
   * @param productDraft  the product draft
   */
  private static void validateUniqueAttribute(String attributeName, ProductDraft productDraft) {
    // TODO: 16/12/19 List<String> should be List<JsonNode>
    List<String> attributes = Lists.newArrayList();

    if (productDraft.getVariants() != null) {
      productDraft.getVariants().stream().forEach(
          productVariantDraft -> {
            productVariantDraft.getAttributes().stream().filter(
                attribute -> attribute.getName().equals(attributeName)
            ).forEach(
                attribute -> {
                  attributes.add(attribute.getValue().toString());
                }
            );
          }
      );
    }

    if (productDraft.getMasterVariant() != null
        && productDraft.getMasterVariant().getAttributes() != null) {
      productDraft.getMasterVariant().getAttributes().stream().filter(
          attribute -> attribute.getName().equals(attributeName)
      ).forEach(
          attribute -> {
            attributes.add(attribute.getValue().toString());
          }
      );
    }

    Set<String> attributeSets = Sets.newHashSet(attributes);
    if (attributeSets.size() < attributes.size()) {
      LOG.debug("unique attribute can not have same value");
      throw new ParametersException("unique attribute can not have same value");
    }
  }
}
