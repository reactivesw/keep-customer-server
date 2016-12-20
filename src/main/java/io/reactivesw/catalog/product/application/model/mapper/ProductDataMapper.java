package io.reactivesw.catalog.product.application.model.mapper;

import io.reactivesw.catalog.product.application.model.ProductData;
import io.reactivesw.catalog.product.application.model.ProductDraft;
import io.reactivesw.catalog.product.application.model.ProductVariant;
import io.reactivesw.catalog.product.domain.entity.ProductDataEntity;
import io.reactivesw.catalog.product.domain.entity.ProductVariantEntity;
import io.reactivesw.common.enums.ReferenceTypes;
import io.reactivesw.common.model.Reference;
import io.reactivesw.common.model.SearchKeyword;
import io.reactivesw.common.model.mapper.LocalizedStringMapper;

import org.apache.commons.lang3.StringUtils;

import java.util.stream.Collectors;

/**
 * Created by Davis on 16/12/14.
 */
public class ProductDataMapper {

  private static int MASTER_VARIANT_ID = 1;

  public static ProductDataEntity modelToEntity(ProductDraft model) {
    ProductDataEntity entity = new ProductDataEntity();

    entity.setName(LocalizedStringMapper.modelToEntityDefaultNew(model.getName()));
    entity.setSlug(LocalizedStringMapper.modelToEntityDefaultNew(model.getSlug()));
    entity.setDescription(LocalizedStringMapper.modelToEntityDefaultNew(model
        .getDescription()));
    entity.setMetaDescription(LocalizedStringMapper.modelToEntityDefaultNew(model
        .getMetaDescription()));
    entity.setMetaTitle(LocalizedStringMapper.modelToEntityDefaultNew(model.getMetaTitle
        ()));
    entity.setMetaKeywords(LocalizedStringMapper.modelToEntityDefaultNew(model
        .getMetaKeywords()));
    if (model.getSearchKeyword() != null) {
      entity.setSearchKeyWords(model.getSearchKeyword().getText());
    }
    ProductVariantEntity masterVariant = new ProductVariantEntity();
    if (model.getMasterVariant() != null) {
      masterVariant = ProductVariantMapper.modelToEntity(MASTER_VARIANT_ID, model
          .getMasterVariant());
    }
    masterVariant.setId(MASTER_VARIANT_ID);
    entity.setMasterVariant(masterVariant);

    if (model.getVariants() != null && !model.getVariants().isEmpty()) {
      entity.setVariants(ProductVariantMapper.modelToEntity(model.getVariants()));
    }

    if (model.getCategories() != null && !model.getCategories().isEmpty()) {
      entity.setCategories(
          model.getCategories().stream().map(
              category -> {
                return category.getId();
              }
          ).collect(Collectors.toList())
      );
    }

    if (model.getCategoryOrderHints() != null && !model.getCategoryOrderHints().isEmpty()) {
      entity.setCategoryOrderHints(CategoryOrderHintsMapper.modelToEntity(
          model.getCategoryOrderHints()));
    }

    return entity;
  }

  public static ProductData entityToModel(ProductDataEntity entity) {
    ProductData model = new ProductData();

    model.setName(LocalizedStringMapper.entityToModelDefaultNull(entity.getName()));
    model.setSlug(LocalizedStringMapper.entityToModelDefaultNull(entity.getSlug()));
    model.setDescription(LocalizedStringMapper.entityToModelDefaultNull(entity.getDescription()));
    model.setMetaTitle(LocalizedStringMapper.entityToModelDefaultNull(entity.getMetaTitle()));
    model.setMetaDescription(LocalizedStringMapper.entityToModelDefaultNull(entity
        .getMetaDescription()));
    model.setMetaKeywords(LocalizedStringMapper.entityToModelDefaultNull(entity.getMetaKeywords()));
    if (StringUtils.isNotBlank(entity.getSearchKeyWords())) {
      model.setSearchKeyword(new SearchKeyword(entity.getSearchKeyWords(), null));
    }
    if (entity.getMasterVariant() != null) {
      model.setMasterVariant(ProductVariantMapper.entityToModel(entity.getMasterVariant()));
    }
    if (entity.getVariants() != null) {
      model.setVariants(ProductVariantMapper.entityToModel(entity.getVariants()));
    }
    if (entity.getCategories() != null) {
      model.setCategories(entity.getCategories().stream().map(
          category -> {
            return new Reference(ReferenceTypes.CATEGORY.getType(), category);
          }
      ).collect(Collectors.toList()));
    }
    if (entity.getCategoryOrderHints() != null) {
      model.setCategoryOrderHints(CategoryOrderHintsMapper.entityToModel(
          entity.getCategoryOrderHints()));
    }
    return model;
  }

}
