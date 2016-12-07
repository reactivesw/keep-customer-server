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
    return entity;
  }

  /**
   * Entity to product type.
   *
   * @param entity the product type entity
   * @return the product type
   */
  public static ProductType entityToModel(ProductTypeEntity entity) {
    ProductType productType = new ProductType();
    return productType;
  }
}
