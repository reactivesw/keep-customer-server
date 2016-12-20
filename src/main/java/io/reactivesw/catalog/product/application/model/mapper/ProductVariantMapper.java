package io.reactivesw.catalog.product.application.model.mapper;

import com.google.common.collect.Sets;

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
    Set entities = Sets.newHashSet();
    for (int i = 0; i <= models.size(); i ++) {
      int id = i + 2;
      ProductVariantEntity entity = modelToEntity(id, models.get(i));
      entities.add(entity);
    }
    return entities;
  }

  public static ProductVariantEntity modelToEntity(int id, ProductVariantDraft model) {
    ProductVariantEntity entity = new ProductVariantEntity();

    entity.setId(id);
    entity.setKey(model.getKey());
    entity.setSku(model.getSku());
    // TODO: 16/12/20  
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
    // TODO: 16/12/20
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
