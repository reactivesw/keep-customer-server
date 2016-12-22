package io.reactivesw.catalog.producttype.application.model.mapper;

import io.reactivesw.catalog.producttype.application.model.action.SetAttributeLabel;
import io.reactivesw.catalog.producttype.domain.entity.ProductTypeEntity;
import io.reactivesw.common.entity.LocalizedStringEntity;
import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.common.model.mapper.LocalizedStringMapper;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Davis on 16/12/12.
 */
public class SetAttributeLabelMapper implements ProductTypeUpdateMapper<ProductTypeEntity> {
  @Override
  public void handle(ProductTypeEntity entity, UpdateAction action) {
    SetAttributeLabel setAttributeLabel = (SetAttributeLabel) action;
    String attributeName = setAttributeLabel.getAttributeName();
    Set<LocalizedStringEntity> label = LocalizedStringMapper.modelToEntityDefaultNew(setAttributeLabel
        .getLabel());

    List attributes = entity.getAttributes().stream().map(
        attribute -> {
          if (Objects.equals(attribute.getName(), attributeName)) {
            attribute.setLabel(label);
          }
          return attribute;
        }
    ).collect(Collectors.toList());

    entity.setAttributes(attributes);
  }
}
