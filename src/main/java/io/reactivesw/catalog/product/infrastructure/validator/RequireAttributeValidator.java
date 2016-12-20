package io.reactivesw.catalog.product.infrastructure.validator;

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
public final class RequireAttributeValidator {
  /**
   * log.
   */
  private static final Logger LOG = LoggerFactory.getLogger(RequireAttributeValidator.class);

  /**
   * private constructor.
   */
  private RequireAttributeValidator() {}

  /**
   * Validate product require attribute.
   *
   * @param attributeDefinitions the attribute definitions
   * @param productDraft         the product draft
   */
  public static void validate(List<AttributeDefinition>
                                                          attributeDefinitions,
                              ProductDraft productDraft) {
    List<String> requireAttributeNames = attributeDefinitions.stream()
        .filter(
            attributeDefinition -> attributeDefinition.getIsRequired().equals(true)
        ).map(
            attributeDefinition -> {
              return attributeDefinition.getName();
            })
        .collect(Collectors.toList());

    if (requireAttributeNames.isEmpty()) {
      return;
    }

    if (productDraft.getMasterVariant() == null) {
      throwExceptionForRequire();
    }

    validateRequireAttribute(requireAttributeNames,
        productDraft.getMasterVariant().getAttributes());

    if (productDraft.getVariants() != null && !productDraft.getVariants().isEmpty()) {
      productDraft.getVariants().stream().forEach(
          productVariantDraft -> {
            validateRequireAttribute(requireAttributeNames, productVariantDraft
                .getAttributes());
          }
      );
    }
  }

  /**
   * Throw exception for require.
   */
  private static void throwExceptionForRequire() {
    LOG.debug("Field 'require' must not be empty");
    throw new ParametersException("Field 'require' must not be empty");
  }

  /**
   * Validate require attribute.
   *
   * @param requireAttributeNames the require attribute names
   * @param attributes            the attributes
   */
  private static void validateRequireAttribute(List<String> requireAttributeNames,
                                               List<Attribute> attributes) {
    if (attributes == null) {
      throwExceptionForRequire();
    }
    List<String> attributeNames = attributes.stream().map(
        attribute -> {
          return attribute.getName();
        }).collect(Collectors.toList());

    if (!attributeNames.containsAll(requireAttributeNames)) {
      throwExceptionForRequire();
    }
  }

}
