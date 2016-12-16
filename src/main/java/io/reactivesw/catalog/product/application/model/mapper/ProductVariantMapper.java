package io.reactivesw.catalog.product.application.model.mapper;

import io.reactivesw.catalog.product.application.model.ProductDraft;
import io.reactivesw.catalog.product.application.model.ProductVariant;
import io.reactivesw.catalog.product.application.model.ProductVariantDraft;
import io.reactivesw.catalog.product.domain.entity.ProductVariantEntity;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Davis on 16/12/14.
 */
public class ProductVariantMapper {

  public static Set<ProductVariantEntity> modelToEntity(List<ProductVariantDraft> models) {
    return models.stream().map(
        model -> {
          return modelToEntity(model);
        }
    ).collect(Collectors.toSet());
  }

  public static ProductVariantEntity modelToEntity(ProductVariantDraft model) {
    ProductVariantEntity entity = new ProductVariantEntity();

    entity.setKey(model.getKey());
    entity.setSku(model.getSku());
//    entity.setImages(model.getImages());
    if (model.getPrices() != null) {
      entity.setPrices(PriceMapper.modelToEntity(model.getPrices()));
    }
    if (model.getAttributes() != null) {
      entity.setAttributes(AttributeMapper.modelToEntity(model.getAttributes()));
    }

    return entity;
  }

  public static ProductVariant entityToModel(ProductVariantEntity entity) {
    ProductVariant model = new ProductVariant();

    model.setId(entity.getId());
    model.setKey(entity.getKey());
    model.setSku(entity.getSku());
    if (entity.getPrices() != null) {
      model.setPrices(PriceMapper.entityToModel(entity.getPrices()));
    }
    if (entity.getAttributes() != null) {
      model.setAttributes(AttributeMapper.entityToModel(entity.getAttributes()));
    }
    if (entity.getImages() != null) {
      model.setImages(ImageMapper.entityToModel(entity.getImages()));
    }
//    model.setIsMatchingVariant();
//    model.setAvailability();
//    model.setPrice();
//    model.setScopedPrice();
//    model.setScopedPriceDiscounted();

    return model;
  }

  public static List<ProductVariant> entityToModel(Set<ProductVariantEntity> entities) {
    return entities.stream().map(
        entity -> {
          return entityToModel(entity);
        }
    ).collect(Collectors.toList());
  }
}
