package io.reactivesw.catalog.producttype.application.model.mapper;

import io.reactivesw.catalog.producttype.application.model.action.RemoveAttribute;
import io.reactivesw.catalog.producttype.domain.entity.ProductTypeEntity;
import io.reactivesw.common.exception.NotExistException;
import io.reactivesw.common.model.UpdateAction;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Davis on 16/12/12.
 */
public class RemoveAttributeMapper implements ProductTypeUpdateMapper<ProductTypeEntity> {
  @Override
  public void setAction(ProductTypeEntity entity, UpdateAction action) {
    String attributeName = ((RemoveAttribute) action).getName();

    Set updateAttributes = entity.getAttributes().stream().filter(
        attribute -> !Objects.equals(attribute.getName(), attributeName)
    ).collect(Collectors.toSet());

    if (updateAttributes.size() == entity.getAttributes().size()) {
      throw new NotExistException("can not find attribute by name : " + attributeName);
    }

    entity.setAttributes(updateAttributes);
  }
}
