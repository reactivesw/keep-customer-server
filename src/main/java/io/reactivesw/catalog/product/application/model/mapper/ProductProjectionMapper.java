package io.reactivesw.catalog.product.application.model.mapper;

import com.google.common.collect.Lists;

import io.reactivesw.catalog.category.application.model.mapper.OrderHintMapper;
import io.reactivesw.catalog.product.application.model.ProductCatalogData;
import io.reactivesw.catalog.product.application.model.ProductProjection;
import io.reactivesw.catalog.product.domain.entity.ProductCatalogDataEntity;
import io.reactivesw.catalog.product.domain.entity.ProductDataEntity;
import io.reactivesw.catalog.product.domain.entity.ProductEntity;
import io.reactivesw.catalog.producttype.application.model.ProductType;
import io.reactivesw.common.enums.ReferenceTypes;
import io.reactivesw.common.model.Reference;
import io.reactivesw.common.model.mapper.LocalizedStringMapper;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Davis on 16/12/21.
 */
public final class ProductProjectionMapper {
  /**
   * Entity to model list.
   *
   * @param entities the entities
   * @return the list
   */
  public static List<ProductProjection> entityToModel(List<ProductEntity> entities) {
    List<ProductProjection> models = Lists.newArrayList();

    models = entities.stream()
        .map(
            entity -> {
              return entityToModel(entity);
            }
        ).collect(Collectors.toList());

    return models;
  }

  /**
   * Entity to model product projection.
   *
   * @param entity the entity
   * @return the product projection
   */
  public static ProductProjection entityToModel(ProductEntity entity) {
    ProductProjection model = new ProductProjection();

    ProductCatalogDataEntity masterData = entity.getMasterData();
    ProductDataEntity currentData = masterData.getCurrent();
    model.setId(entity.getId());
    model.setKey(entity.getKey());
    model.setName(LocalizedStringMapper.entityToModelDefaultNull(currentData.getName()));
    model.setSlug(currentData.getSlug());
    model.setDescription(LocalizedStringMapper.entityToModelDefaultNull(
        currentData.getDescription()));
    model.setCreatedAt(entity.getCreatedAt());
    model.setLastModifiedAt(entity.getLastModifiedAt());
    model.setMetaTitle(LocalizedStringMapper.entityToModelDefaultNull(currentData.getMetaTitle()));
    model.setMetaDescription(LocalizedStringMapper.entityToModelDefaultNull(
        currentData.getMetaDescription()));
    model.setMetaKeywords(LocalizedStringMapper.entityToModelDefaultNull(
        currentData.getMetaKeywords()));
    if (currentData.getCategories() != null && !currentData.getCategories().isEmpty()) {
      model.setCategories(currentData.getCategories().stream().map(
          category -> {
            return new Reference(ReferenceTypes.CATEGORY.getType(), category);
          }
      ).collect(Collectors.toList()));
    }
    if (currentData.getCategoryOrderHints() != null) {
      model.setCategoryOrderHints(CategoryOrderHintsMapper.entityToModel(
          currentData.getCategoryOrderHints()));
    }
    model.setMasterVariant(ProductVariantMapper.entityToModel(currentData.getMasterVariant()));
    model.setVariants(ProductVariantMapper.entityToModel(currentData.getVariants()));
    model.setProductType(new Reference(ReferenceTypes.PRODUCTTYPE.getType(),
        entity.getProductType()));
    model.setHasStagedChanges(masterData.getStagedChanged());
    model.setPublished(masterData.getPublished());
//    model.setSearchKeyword();
//    model.setTaxCategory();
//    model.setState();
//    model.setReviewRatingStatistics();

    return model;
  }
}
