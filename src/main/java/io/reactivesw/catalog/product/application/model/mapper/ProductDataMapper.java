package io.reactivesw.catalog.product.application.model.mapper;

import io.reactivesw.catalog.product.application.model.ProductData;
import io.reactivesw.catalog.product.application.model.ProductDraft;
import io.reactivesw.catalog.product.application.model.ProductVariant;
import io.reactivesw.catalog.product.domain.entity.ProductDataEntity;
import io.reactivesw.common.model.SearchKeyword;
import io.reactivesw.common.model.mapper.LocalizedStringMapper;

/**
 * Created by Davis on 16/12/14.
 */
public class ProductDataMapper {
  public static ProductDataEntity modelToEntity(ProductDraft productDraft) {
    ProductDataEntity entity = new ProductDataEntity();

    entity.setName(LocalizedStringMapper.modelToEntityDefaultNull(productDraft.getName()));
    entity.setSlug(LocalizedStringMapper.modelToEntityDefaultNull(productDraft.getSlug()));
    entity.setDescription(LocalizedStringMapper.modelToEntityDefaultNull(productDraft
        .getDescription()));
    entity.setMetaDescription(LocalizedStringMapper.modelToEntityDefaultNull(productDraft
        .getMetaDescription()));
    entity.setMetaTitle(LocalizedStringMapper.modelToEntityDefaultNull(productDraft.getMetaTitle
        ()));
    entity.setMetaKeywords(LocalizedStringMapper.modelToEntityDefaultNull(productDraft
        .getMetaKeywords()));
    entity.setSearchKeyWords(productDraft.getSearchKeyword().getText());
    entity.setMasterVariant(ProductVariantMapper.modelToEntity(productDraft.getMasterVariant()));
    entity.setVariants(ProductVariantMapper.modelToEntity(productDraft.getVariants()));

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
    model.setSearchKeyword(new SearchKeyword(entity.getSearchKeyWords(), null));
    model.setMasterVariant(ProductVariantMapper.entityToModel(entity.getMasterVariant()));
    model.setVariants(ProductVariantMapper.entityToModel(entity.getVariants()));



    return model;
  }

}
