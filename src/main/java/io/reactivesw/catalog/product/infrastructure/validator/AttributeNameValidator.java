package io.reactivesw.catalog.product.infrastructure.validator;

import com.google.common.collect.Lists;

import io.reactivesw.catalog.product.application.model.ProductDraft;
import io.reactivesw.catalog.product.application.model.attributes.Attribute;
import io.reactivesw.catalog.product.application.model.attributes.AttributeDefinition;
import io.reactivesw.common.exception.ParametersException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Davis on 16/12/20.
 */
public final class AttributeNameValidator {
  /**
   * log.
   */
  private static final Logger LOG = LoggerFactory.getLogger(AttributeNameValidator.class);

  /**
   * private constructor.
   */
  private AttributeNameValidator() {}
  
  /**
   * validate attribute name.
   *
   * @param attributeDefinitions List of AttributeDefinition
   * @param productDraft         ProductDraft
   */
  public static void validate(List<AttributeDefinition> attributeDefinitions,
                              ProductDraft productDraft) {
    List<String> attributeNames = getAttributeDefinitionNames(attributeDefinitions);

    List<List<String>> attributeDraftNames = getAllAttributeNames(productDraft);

    attributeDraftNames.stream().forEach(
        attribute -> {
          if (!attributeNames.containsAll(attribute)) {
            LOG.debug("attribute not match, producttype should contains all attributes");
            throw new ParametersException("Attribute Not Match");
          }
        }
    );
  }

  /**
   * Gets attribute definition names.
   *
   * @param attributeDefinitions the attribute definitions
   * @return the attribute definition names
   */
  private static List<String> getAttributeDefinitionNames(List<AttributeDefinition>
                                                              attributeDefinitions) {
    return attributeDefinitions.stream().map(
        attributeDefinition -> {
          return attributeDefinition.getName();
        }).collect(Collectors.toList());
  }

  /**
   * Gets all attribute names.
   *
   * @param productDraft the product draft
   * @return the all attribute names
   */
  private static List<List<String>> getAllAttributeNames(ProductDraft productDraft) {
    List<List<String>> result = Lists.newArrayList();
    if (productDraft.getMasterVariant() != null) {
      result.add(getAttributeNames(productDraft.getMasterVariant().getAttributes()));
    }

    if (productDraft.getVariants() != null) {
      result.addAll(productDraft.getVariants().stream().map(
          productVariantDraft -> {
            return getAttributeNames(productVariantDraft.getAttributes());
          })
          .collect(Collectors.toList()));
    }

    return result;
  }

  /**
   * Gets attribute names.
   *
   * @param attributes the attributes
   * @return the attribute names
   */
  private static List<String> getAttributeNames(List<Attribute> attributes) {
    List<String> result = Lists.newArrayList();
    if (attributes != null) {
      result = attributes.stream().map(
          attribute -> {
            return attribute.getName();
          }
      ).collect(Collectors.toList());
    }
    return result;
  }
}
