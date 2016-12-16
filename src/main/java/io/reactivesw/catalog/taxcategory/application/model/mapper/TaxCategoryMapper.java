package io.reactivesw.catalog.taxcategory.application.model.mapper;

import io.reactivesw.catalog.taxcategory.application.model.TaxCategory;
import io.reactivesw.catalog.taxcategory.application.model.TaxCategoryDraft;
import io.reactivesw.catalog.taxcategory.domain.entity.TaxCategoryEntity;
import io.reactivesw.common.enums.ReferenceTypes;
import io.reactivesw.common.model.Reference;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import jdk.nashorn.internal.ir.annotations.Ignore;

/**
 * Created by Davis on 16/12/10.
 */
public final class TaxCategoryMapper {

  /**
   * convert TaxCategoryDraft to TaxCategory.
   *
   * @param draft the TaxCategoryDraft
   * @return the TaxCategory
   */
  public static TaxCategoryEntity modelToEntity(TaxCategoryDraft draft) {
    TaxCategoryEntity entity = new TaxCategoryEntity();

    //1 should be a config for all entity
    entity.setVersion(1);
    entity.setName(draft.getName());
    entity.setDescription(draft.getDescription());
    entity.setRates(TaxRateMapper.modelToEntity(draft.getRates()));

    return entity;
  }

  /**
   * convert TaxCategory to TaxCategory.
   *
   * @param entity the TaxCategory
   * @return the TaxCategory
   */
  public static TaxCategory entityToModel(TaxCategoryEntity entity) {
    TaxCategory model = new TaxCategory();

    model.setId(entity.getId());
    model.setName(entity.getName());
    model.setCreatedAt(entity.getCreatedAt());
    model.setLastModifiedAt(entity.getLastModifiedAt());
    model.setDescription(entity.getDescription());
    model.setVersion(entity.getVersion());
    model.setRates(TaxRateMapper.entityToModel(entity.getRates()));

    return model;
  }

  /**
   * convert List of TaxCategoryEntity to List of TaxCategory.
   *
   * @param entities the List of TaxCategoryEntity
   * @return the List of TaxCategory
   */
  public static List<TaxCategory> entityToModel(List<TaxCategoryEntity> entities) {
    List result = entities.stream().map(
        entity -> {
          return entityToModel(entity);
        }
    ).collect(Collectors.toList());
    return result;
  }

  public static Reference entityToReference(String taxCategoryId) {
    Reference reference = null;
    if (StringUtils.isNotBlank(taxCategoryId)) {
      reference = new Reference(ReferenceTypes.TAXCATEGORY.getType(), taxCategoryId);
    }
    return reference;
  }
}
