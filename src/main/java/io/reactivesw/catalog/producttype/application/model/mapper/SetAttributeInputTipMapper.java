package io.reactivesw.catalog.producttype.application.model.mapper;

import io.reactivesw.catalog.producttype.application.model.action.SetAttributeInputTip;
import io.reactivesw.catalog.producttype.domain.entity.AttributeDefinitionEntity;
import io.reactivesw.catalog.producttype.domain.entity.ProductTypeEntity;
import io.reactivesw.common.model.LocalizedString;
import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.common.model.mapper.LocalizedStringMapper;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by Davis on 16/12/12.
 */
public class SetAttributeInputTipMapper implements ProductTypeUpdateMapper<ProductTypeEntity> {
  @Override
  public void setAction(ProductTypeEntity entity, UpdateAction action) {
    SetAttributeInputTip setAttributeInputTip = (SetAttributeInputTip) action;
    String attributeName = setAttributeInputTip.getAttributeName();
    LocalizedString inputTip = setAttributeInputTip.getInputTip();

    Set<AttributeDefinitionEntity> attributes = entity.getAttributes().stream()
        .map(
            attribute -> {
              if (Objects.equals(attributeName, attribute.getName())) {
                attribute.setLabel(LocalizedStringMapper.modelToEntityDefaultNew(inputTip));
              }
              return attribute;
            }
        ).collect(Collectors.toSet());

    entity.setAttributes(attributes);
  }
}
