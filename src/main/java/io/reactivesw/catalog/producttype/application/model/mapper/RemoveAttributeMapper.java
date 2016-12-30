package io.reactivesw.catalog.producttype.application.model.mapper;

import io.reactivesw.catalog.producttype.application.model.action.RemoveAttributeDefinition;
import io.reactivesw.catalog.producttype.domain.entity.ProductTypeEntity;
import io.reactivesw.common.exception.NotExistException;
import io.reactivesw.common.model.UpdateAction;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by Davis on 16/12/12.
 */
public class RemoveAttributeMapper implements ProductTypeUpdateMapper<ProductTypeEntity> {
  @Override
  public void handle(ProductTypeEntity entity, UpdateAction action) {
    String attributeName = ((RemoveAttributeDefinition) action).getName();

    List updateAttributes = entity.getAttributes().stream().filter(
        attribute -> !Objects.equals(attribute.getName(), attributeName)
    ).collect(Collectors.toList());

    if (updateAttributes.size() == entity.getAttributes().size()) {
      throw new NotExistException("can not find attribute by name : " + attributeName);
    }

    entity.setAttributes(updateAttributes);
  }
}
