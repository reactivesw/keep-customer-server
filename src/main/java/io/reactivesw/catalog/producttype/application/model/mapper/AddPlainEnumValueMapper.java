package io.reactivesw.catalog.producttype.application.model.mapper;

import io.reactivesw.catalog.product.application.model.attributes.EnumAttributeType;
import io.reactivesw.catalog.producttype.application.model.action.AddPlainEnumValue;
import io.reactivesw.catalog.producttype.domain.entity.ProductTypeEntity;
import io.reactivesw.common.enums.EnumValue;
import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.common.model.mapper.EnumValueMapper;

import java.util.Objects;

/**
 * Created by Davis on 16/12/12.
 */
public class AddPlainEnumValueMapper implements ProductTypeUpdateMapper<ProductTypeEntity>{
  @Override
  public void setAction(ProductTypeEntity entity, UpdateAction action) {
    AddPlainEnumValue setAttributeInputTip = (AddPlainEnumValue) action;
    String attributeName = setAttributeInputTip.getAttributeName();
    EnumValue enumValue = EnumValueMapper.modelToEntity(setAttributeInputTip.getValue());

    entity.getAttributes()
        .stream().map(
            attribute -> {
              if (Objects.equals(attributeName, attribute.getName())) {
                EnumAttributeType enumAttributeType = (EnumAttributeType)attribute.getType();
                // TODO: 16/12/12 if values is null?
                enumAttributeType.getValues().add(enumValue);
                attribute.setType(enumAttributeType);
              }
             return attribute;
            }
    );
  }
}
