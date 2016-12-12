package io.reactivesw.catalog.producttype.application.model.mapper;

import io.reactivesw.catalog.producttype.application.model.ProductType;
import io.reactivesw.catalog.producttype.application.model.ProductTypeDraft;
import io.reactivesw.catalog.producttype.domain.entity.ProductTypeEntity;

/**
 * Created by Davis on 16/12/7.
 */
public final class ProductTypeMapper {
  /**
   * Model to product type entity.
   *
   * @param draft the product type draft
   * @return the product type entity
   */
  public static ProductTypeEntity modelToEntity(ProductTypeDraft draft) {
    ProductTypeEntity entity = new ProductTypeEntity();
    entity.setName(draft.getName());
    entity.setKey(draft.getKey());
    entity.setDescription(draft.getDescription());
    entity.setAttributes(AttributeDefinitionMapper.modelToEntity(draft.getAttributes()));
    return entity;
  }

  /**
   * Entity to product type.
   *
   * @param entity the product type entity
   * @return the product type
   */
  public static ProductType entityToModel(ProductTypeEntity entity) {
    ProductType model = new ProductType();
    model.setName(entity.getName());
    model.setDescription(entity.getDescription());
    model.setCreatedAt(entity.getCreatedAt());
    model.setLastModifiedAt(entity.getLastModifiedAt());
    model.setId(entity.getId());
    model.setKey(entity.getKey());
    model.setVersion(entity.getVersion());
    model.setAttributes(AttributeDefinitionMapper.entityToModel(entity.getAttributes()));
    return model;
  }
}
