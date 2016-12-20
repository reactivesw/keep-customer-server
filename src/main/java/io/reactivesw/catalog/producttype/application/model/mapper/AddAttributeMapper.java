package io.reactivesw.catalog.producttype.application.model.mapper;

import io.reactivesw.catalog.producttype.application.model.action.AddAttribute;
import io.reactivesw.catalog.producttype.domain.entity.AttributeDefinitionEntity;
import io.reactivesw.catalog.producttype.domain.entity.ProductTypeEntity;
import io.reactivesw.common.model.UpdateAction;

import com.google.common.collect.Sets;

import java.util.Set;

/**
 * Created by Davis on 16/12/12.
 */
public class AddAttributeMapper implements ProductTypeUpdateMapper<ProductTypeEntity> {
  @Override
  public void handle(ProductTypeEntity entity, UpdateAction action) {
    AddAttribute addAttributeDefinition = (AddAttribute) action;
    AttributeDefinitionEntity attributeDefinitionEntity = AttributeDefinitionMapper.modelToEntity
        (addAttributeDefinition.getAttribute());

    Set<AttributeDefinitionEntity> attributes = entity.getAttributes();
    if (attributes == null) {
      attributes = Sets.newHashSet();
    }
    attributes.add(attributeDefinitionEntity);

    entity.setAttributes(attributes);
  }
}
