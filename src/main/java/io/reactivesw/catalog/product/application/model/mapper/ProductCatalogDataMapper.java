package io.reactivesw.catalog.product.application.model.mapper;

import io.reactivesw.catalog.product.application.model.ProductCatalogData;
import io.reactivesw.catalog.product.application.model.ProductDraft;
import io.reactivesw.catalog.product.domain.entity.ProductCatalogDataEntity;

/**
 * Created by Davis on 16/12/14.
 */
public class ProductCatalogDataMapper {
  public static ProductCatalogDataEntity modelToEntity(ProductDraft model) {
    ProductCatalogDataEntity entity = new ProductCatalogDataEntity();

    entity.setPublished(false);
    entity.setStagedChanged(false);
    entity.setCurrent(ProductDataMapper.modelToEntity(model));
    entity.setStaged(ProductDataMapper.modelToEntity(model));

    return entity;
  }

  public static ProductCatalogData entityToModel(ProductCatalogDataEntity entity) {
    ProductCatalogData model = new ProductCatalogData();

    model.setPublished(entity.getPublished());
    model.setHasStagedChanges(entity.getStagedChanged());
    model.setCurrent(ProductDataMapper.entityToModel(entity.getCurrent()));
    model.setStaged(ProductDataMapper.entityToModel(entity.getStaged()));

    return model;
  }
}
