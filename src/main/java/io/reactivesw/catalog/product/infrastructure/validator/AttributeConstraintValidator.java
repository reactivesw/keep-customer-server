package io.reactivesw.catalog.product.infrastructure.validator;

import io.reactivesw.catalog.product.application.model.ProductDraft;
import io.reactivesw.catalog.product.application.model.attributes.AttributeDefinition;

import java.util.List;

/**
 * Created by Davis on 16/12/20.
 */
public final class AttributeConstraintValidator {

  /**
   * private constructor.
   */
  private AttributeConstraintValidator() {
  }

  /**
   * Validate attribute.
   *
   * @param attributeDefinitions the attribute definitions
   * @param productDraft         the product draft
   */
  public static void validate(List<AttributeDefinition> attributeDefinitions,
                              ProductDraft productDraft) {
    if (attributeDefinitions != null) {
      //1. require的attribute
      RequireAttributeValidator.validate(attributeDefinitions, productDraft);
      //2. attribute name
      AttributeNameValidator.validate(attributeDefinitions, productDraft);
      //3. unique 比对一下所有都不相同
      UniqueAttributeValidator.validate(attributeDefinitions, productDraft);
      //4. combination unique 组合不相同,需要比对
      CombinationAttributeValidator.validate(attributeDefinitions, productDraft);
      //5. same for all
      SameForAllAttributeValidator.validate(attributeDefinitions, productDraft);
      //6. none 不需要考虑
    }
  }
}
