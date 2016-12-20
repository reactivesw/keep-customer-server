package io.reactivesw.catalog.product.infrastructure.validator;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import io.reactivesw.catalog.product.application.model.ProductDraft;
import io.reactivesw.catalog.product.application.model.attributes.Attribute;
import io.reactivesw.catalog.product.application.model.attributes.AttributeConstraint;
import io.reactivesw.catalog.product.application.model.attributes.AttributeDefinition;
import io.reactivesw.common.exception.ParametersException;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
   * Validate attribute.
   *
   * @param attributeDefinitions the attribute definitions
   * @param productDraft         the product draft
   */
  public static void validateAttribute(List<AttributeDefinition> attributeDefinitions,
                                       ProductDraft productDraft) {
    if (attributeDefinitions != null) {
      //2. require的attribute
      validateProductRequireAttribute(attributeDefinitions, productDraft);
      //1. attribute name
      validateAttributeName(attributeDefinitions, productDraft);
      //null attribute value
      // TODO: 16/12/20
      //3. unique 比对一下所有都不相同
      validateProductUniqueAttribuate(attributeDefinitions, productDraft);
      //4. combination unique 组合不相同,需要比对
      validateCombinationUniqueAttribute(attributeDefinitions, productDraft);
      //5. same for all
      validateSameForAllAttribute(attributeDefinitions, productDraft);
      //6. none 不需要考虑
    }
  }

  /**
   * validate attribute name.
   *
   * @param attributeDefinitions List of AttributeDefinition
   * @param productDraft         ProductDraft
   */
  private static void validateAttributeName(List<AttributeDefinition> attributeDefinitions,
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

  /**
   * Validate product require attribute.
   *
   * @param attributeDefinitions the attribute definitions
   * @param productDraft         the product draft
   */
  private static void validateProductRequireAttribute(List<AttributeDefinition>
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

  /**
   * Validate product unique attribuate.
   *
   * @param attributeDefinitions the attribute definitions
   * @param productDraft         the product draft
   */
  private static void validateProductUniqueAttribuate(List<AttributeDefinition>
                                                          attributeDefinitions,
                                                      ProductDraft productDraft) {
    List<String> uniqueAttributes = getAttributeNameByConstraint(attributeDefinitions,
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

  /**
   * Validate combination unique attribute.
   *
   * @param attributeDefinitions the attribute definitions
   * @param productDraft         the product draft
   */
  private static void validateCombinationUniqueAttribute(List<AttributeDefinition>
                                                             attributeDefinitions,
                                                         ProductDraft productDraft) {
    List<String> combinationUniqueAttribute = getAttributeNameByConstraint(attributeDefinitions,
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
          validateCombinationUniqueAttribute(attribute, attributes);
        }
    );
  }

  /**
   * Validate combination unique attribute.
   *
   * @param attributes     the attributes
   * @param attributeLists the attribute lists
   */
  private static void validateCombinationUniqueAttribute(List<String> attributes,
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

  /**
   * Validate same for all attribute.
   *
   * @param attributeDefinitions the attribute definitions
   * @param productDraft         the product draft
   */
  private static void validateSameForAllAttribute(List<AttributeDefinition> attributeDefinitions,
                                                  ProductDraft productDraft) {
    List<String> attributeNames = getAttributeNameByConstraint(attributeDefinitions,
        AttributeConstraint.SameForAll);

    attributeNames.forEach(
        attributeName -> {
          validateSameForAllAttribute(attributeName, productDraft);
        }
    );
  }

  /**
   * Validate same for all attribute.
   *
   * @param attributeName the attribute name
   * @param productDraft  the product draft
   */
  private static void validateSameForAllAttribute(String attributeName, ProductDraft productDraft) {
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

  /**
   * Gets attribute name by constraint.
   *
   * @param attributeDefinitions the attribute definitions
   * @param attributeConstraint  the attribute constraint
   * @return the attribute name by constraint
   */
  private static List<String> getAttributeNameByConstraint(List<AttributeDefinition>
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
