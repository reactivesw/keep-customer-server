package io.reactivesw.catalog.producttype.domain.service.update;

import io.reactivesw.catalog.producttype.application.model.action.SetAttributeInputTip;
import io.reactivesw.catalog.producttype.domain.entity.AttributeDefinitionEntity;
import io.reactivesw.catalog.producttype.domain.entity.ProductTypeEntity;
import io.reactivesw.catalog.producttype.infrastructure.util.ProductTypeActionUtils;
import io.reactivesw.common.entity.LocalizedStringEntity;
import io.reactivesw.common.model.Update;
import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.common.model.mapper.LocalizedStringMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Davis on 16/12/12.
 */
@Service(value = ProductTypeActionUtils.SET_ATTRIBUTE_DEFINITION_INPUTTIP)
public class SetAttributeInputTipService implements Update<ProductTypeEntity> {
  /**
   * set attribute input tip.
   * @param entity E
   * @param action UpdateAction
   */
  @Override
  public void handle(ProductTypeEntity entity, UpdateAction action) {
    SetAttributeInputTip setAttributeInputTip = (SetAttributeInputTip) action;
    String attributeName = setAttributeInputTip.getAttributeName();
    Set<LocalizedStringEntity> inputTip = LocalizedStringMapper.modelToEntityDefaultNew(
        setAttributeInputTip.getInputTip());

    List<AttributeDefinitionEntity> attributes = entity.getAttributes().stream()
        .map(
            attribute -> {
              if (Objects.equals(attributeName, attribute.getName())) {
                attribute.setInputTip(inputTip);
              }
              return attribute;
            }
        ).collect(Collectors.toList());

    entity.setAttributes(attributes);
  }
}
