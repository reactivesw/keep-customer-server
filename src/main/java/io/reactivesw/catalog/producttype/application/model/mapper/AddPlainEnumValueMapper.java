package io.reactivesw.catalog.producttype.application.model.mapper;

import io.reactivesw.catalog.product.model.attributes.EnumAttributeType;
import io.reactivesw.catalog.producttype.application.model.action.AddPlainEnumValue;
import io.reactivesw.catalog.producttype.application.model.action.SetAttributeInputTip;
import io.reactivesw.catalog.producttype.domain.entity.AttributeDefinitionEntity;
import io.reactivesw.catalog.producttype.domain.entity.ProductTypeEntity;
import io.reactivesw.common.enums.EnumValue;
import io.reactivesw.common.model.LocalizedString;
import io.reactivesw.common.model.PlainEnumValue;
import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.common.model.mapper.EnumValueMapper;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

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
