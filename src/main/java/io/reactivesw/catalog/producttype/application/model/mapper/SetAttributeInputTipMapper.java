package io.reactivesw.catalog.producttype.application.model.mapper;

import io.reactivesw.catalog.producttype.application.model.action.SetAttributeInputTip;
import io.reactivesw.catalog.producttype.domain.entity.AttributeDefinitionEntity;
import io.reactivesw.catalog.producttype.domain.entity.ProductTypeEntity;
import io.reactivesw.common.model.LocalizedString;
import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.common.model.mapper.LocalizedStringMapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by Davis on 16/12/12.
 */
public class SetAttributeInputTipMapper implements ProductTypeUpdateMapper<ProductTypeEntity> {
  @Override
  public void handle(ProductTypeEntity entity, UpdateAction action) {
    SetAttributeInputTip setAttributeInputTip = (SetAttributeInputTip) action;
    String attributeName = setAttributeInputTip.getAttributeName();
    LocalizedString inputTip = setAttributeInputTip.getInputTip();

    List<AttributeDefinitionEntity> attributes = entity.getAttributes().stream()
        .map(
            attribute -> {
              if (Objects.equals(attributeName, attribute.getName())) {
                attribute.setLabel(LocalizedStringMapper.modelToEntityDefaultNew(inputTip));
              }
              return attribute;
            }
        ).collect(Collectors.toList());

    entity.setAttributes(attributes);
  }
}
