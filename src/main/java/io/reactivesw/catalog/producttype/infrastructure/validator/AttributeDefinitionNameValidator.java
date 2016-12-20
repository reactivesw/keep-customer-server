package io.reactivesw.catalog.producttype.infrastructure.validator;

import com.google.common.collect.Sets;

import io.reactivesw.catalog.product.application.model.AttributeDefinitionDraft;
import io.reactivesw.catalog.producttype.application.model.ProductTypeDraft;
import io.reactivesw.common.exception.ParametersException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Davis on 16/12/20.
 */
public final class AttributeDefinitionNameValidator {
  /**
   * log.
   */
  private static final Logger LOG = LoggerFactory.getLogger(AttributeDefinitionNameValidator.class);
  
  /**
   * private constructor.
   */
  private AttributeDefinitionNameValidator() {}


  /**
   * Validate if attribute name is unique.
   *
   * @param productTypeDraft the product type draft
   */
  public static void validate(ProductTypeDraft productTypeDraft) {
    List<AttributeDefinitionDraft> attributeDefinitions = productTypeDraft.getAttributes();
    if (attributeDefinitions != null && !attributeDefinitions.isEmpty()){
      List<String> attributeDefinitionNames = attributeDefinitions.stream().map(
          attributeDefinitionDraft -> {
            return attributeDefinitionDraft.getName();
          }
      ).collect(Collectors.toList());

      Set<String> attributeSets = Sets.newHashSet(attributeDefinitionNames);
      if (attributeSets.size() < attributeDefinitionNames.size()) {
        LOG.debug("attribute name should be unique");
        throw new ParametersException("attribute name should be unique");
      }
    }
  }
}
