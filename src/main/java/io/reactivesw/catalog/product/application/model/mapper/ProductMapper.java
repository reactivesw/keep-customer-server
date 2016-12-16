package io.reactivesw.catalog.product.application.model.mapper;

import io.reactivesw.catalog.product.application.model.Product;
import io.reactivesw.catalog.product.application.model.ProductDraft;
import io.reactivesw.catalog.product.domain.entity.ProductEntity;
import io.reactivesw.catalog.producttype.application.model.mapper.ProductTypeMapper;
import io.reactivesw.catalog.taxcategory.application.model.mapper.TaxCategoryMapper;

/**
 * Created by Davis on 16/12/14.
 */
public final class ProductMapper {

  /**
   * convert ProductDraft to ProductEntity.
   *
   * @param model the ProductDraft
   * @return the ProductEntity
   */
  public static ProductEntity modelToEntity(ProductDraft model) {
    ProductEntity entity = new ProductEntity();

    entity.setKey(model.getKey());
    if (model.getState() != null) {
      entity.setState(model.getState().getId());
    }
    entity.setProductType(model.getProductType().getId());
    if (model.getTaxCategory() != null) {
      entity.setTaxCategory(model.getTaxCategory().getId());
    }
    entity.setMasterData(ProductCatalogDataMapper.modelToEntity(model));

    return entity;
  }

  /**
   * convert ProductEntity to Product.
   *
   * @param entity the ProductEntity
   * @return the Product
   */
  public static Product entityToModel(ProductEntity entity) {
    Product model = new Product();

    model.setCreatedAt(entity.getCreatedAt());
    model.setLastModifiedAt(entity.getLastModifiedAt());
    model.setId(entity.getId());
    model.setKey(entity.getKey());
    model.setVersion(entity.getVersion());
    model.setTaxCategory(TaxCategoryMapper.entityToReference(entity.getTaxCategory()));
    model.setProductType(ProductTypeMapper.entityToReference(entity.getProductType()));
//    model.setState(entity.getState());
//    model.setReviewRatingStatistics();
    model.setMasterData(ProductCatalogDataMapper.entityToModel(entity.getMasterData()));


    return model;
  }
}
