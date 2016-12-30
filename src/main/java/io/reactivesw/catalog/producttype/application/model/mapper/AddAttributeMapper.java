package io.reactivesw.catalog.producttype.application.model.mapper;

import io.reactivesw.catalog.producttype.application.model.action.AddAttributeDefinition;
import io.reactivesw.catalog.producttype.domain.entity.AttributeDefinitionEntity;
import io.reactivesw.catalog.producttype.domain.entity.ProductTypeEntity;
import io.reactivesw.common.model.UpdateAction;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by Davis on 16/12/12.
 */
public class AddAttributeMapper implements ProductTypeUpdateMapper<ProductTypeEntity> {
  @Override
  public void handle(ProductTypeEntity entity, UpdateAction action) {
    AddAttributeDefinition addAttributeDefinition = (AddAttributeDefinition) action;
    AttributeDefinitionEntity attributeDefinitionEntity = AttributeDefinitionMapper.modelToEntity
        (addAttributeDefinition.getAttribute());

    List<AttributeDefinitionEntity> attributes = entity.getAttributes();
    if (attributes == null) {
      attributes = Lists.newArrayList();
    }
    attributes.add(attributeDefinitionEntity);

    entity.setAttributes(attributes);
  }
}
