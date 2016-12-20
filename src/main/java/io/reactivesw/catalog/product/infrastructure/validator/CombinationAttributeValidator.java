package io.reactivesw.catalog.product.infrastructure.validator;

import com.google.common.collect.Lists;

import io.reactivesw.catalog.product.application.model.ProductDraft;
import io.reactivesw.catalog.product.application.model.attributes.AttributeConstraint;
import io.reactivesw.catalog.product.application.model.attributes.AttributeDefinition;
import io.reactivesw.catalog.product.infrastructure.utils.AttributeUtils;
import io.reactivesw.common.exception.ParametersException;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Davis on 16/12/20.
 */
public final class CombinationAttributeValidator {
  /**
   * log.
   */
  private static final Logger LOG = LoggerFactory.getLogger(CombinationAttributeValidator.class);

  /**
   * private constructor.
   */
  private CombinationAttributeValidator() {
  }

  /**
   * Validate combination unique attribute.
   *
   * @param attributeDefinitions the attribute definitions
   * @param productDraft         the product draft
   */
  public static void validate(List<AttributeDefinition>
                                  attributeDefinitions,
                              ProductDraft productDraft) {
    List<String> combinationUniqueAttribute = AttributeUtils.getAttributeNameByConstraint
        (attributeDefinitions,
        AttributeConstraint.CombinationUnique);
    // TODO: 16/12/19 List<String> should be List<JsonNode>
    List<List<String>> attributes = Lists.newArrayList();

    if (productDraft.getMasterVariant() != null
        && productDraft.getMasterVariant().getAttributes() != null) {
      List<String> masterAttributes = productDraft.getMasterVariant().getAttributes().stream()
          .filter(
              attribute -> combinationUniqueAttribute.contains(attribute.getName())
          ).map(attribute -> {
            return attribute.getValue().toString();
          }).collect(Collectors.toList());
      if (masterAttributes != null && !masterAttributes.isEmpty()) {
        attributes.add(masterAttributes);
      }
    }

    if (productDraft.getVariants() != null) {
      List<List<String>> variantAttributes = productDraft.getVariants().stream().filter(
          productVariantDraft -> productVariantDraft.getAttributes() != null
      ).map(
          productVariantDraft -> {
            return
                productVariantDraft.getAttributes().stream().filter(
                    attribute -> combinationUniqueAttribute.contains(attribute.getName())
                ).map(attribute -> {
                  return attribute.getValue().toString();
                }).collect(Collectors.toList());
          }).collect(Collectors.toList());

      if (variantAttributes != null && !variantAttributes.isEmpty()) {
        attributes.addAll(variantAttributes);
      }
    }

    attributes.stream().forEach(
        attribute -> {
          validate(attribute, attributes);
        }
    );
  }

  /**
   * Validate combination unique attribute.
   *
   * @param attributes     the attributes
   * @param attributeLists the attribute lists
   */
  private static void validate(List<String> attributes,
                               List<List<String>> attributeLists) {
    int correctNumber = 1;
    int result = 0;
    for (List list : attributeLists) {
      if (CollectionUtils.isEqualCollection(list, attributes)) {
        result += 1;
      }
    }

    if (result > correctNumber) {
      LOG.debug("combination unique attribute can not have same combination value");
      throw new ParametersException(
          "combination unique attribute can not have same combination value");
    }
  }
}
