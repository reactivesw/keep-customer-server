package io.reactivesw.catalog.product.application.model.mapper;

import io.reactivesw.catalog.product.application.model.Price;
import io.reactivesw.catalog.product.application.model.PriceDraft;
import io.reactivesw.catalog.product.domain.entity.PriceEntity;
import io.reactivesw.catalog.productdiscount.model.mapper.DiscountedPriceMapper;
import io.reactivesw.common.enums.ReferenceTypes;
import io.reactivesw.common.model.Reference;
import io.reactivesw.common.model.mapper.CustomFieldsMapper;
import io.reactivesw.common.model.mapper.MoneyMapper;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import antlr.StringUtils;

/**
 * Created by Davis on 16/12/14.
 */
public class PriceMapper {

  public static Set<PriceEntity> modelToEntity(List<PriceDraft> models) {
    return models.stream().map(
        model -> {
          return modelToEntity(model);
        }
    ).collect(Collectors.toSet());
  }

  public static PriceEntity modelToEntity(PriceDraft model) {
    PriceEntity entity = new PriceEntity();

    entity.setCountry(model.getCountry());
    entity.setValue(MoneyMapper.modelToEntity(model.getValue()));
    if (model.getChannel() != null) {
      entity.setChannel(model.getChannel().getId());
    }
    if (model.getValidFrom() != null) {
      entity.setValidFrom(model.getValidFrom());
    }
    if (model.getValidUntil() != null) {
      entity.setValidUntil(model.getValidUntil());
    }
    if (model.getCustomerGroup() != null) {
      entity.setCustomerGroup(model.getCustomerGroup().getId());
    }
    if (model.getCustom() != null) {
      entity.setCustom(CustomFieldsMapper.modelToEntity(model.getCustom()));
    }

    return entity;
  }

  public static Price entityToModel(PriceEntity entity) {
    Price model = new Price();

    if (model.getChannel() != null) {
      model.setChannel(new Reference(ReferenceTypes.CHANNEL.getType(), entity.getChannel()));
    }
    model.setCountry(entity.getCountry());
    model.setId(entity.getId());
    model.setValidFrom(entity.getValidFrom());
    model.setValidUntil(entity.getValidUntil());
    model.setValue(MoneyMapper.entityToModel(entity.getValue()));
    if (model.getCustomerGroup() != null) {
      model.setCustomerGroup(new Reference(ReferenceTypes.CUSTOMERGROUP.getType(), entity
          .getCustomerGroup()));
    }
    // TODO: 16/12/14 discount should calculate
//    model.setDiscounted(DiscountedPriceMapper.entityToModel(entity.getDiscounted()));
    model.setCustom(entity.getCustom());

    return model;
  }

  public static List<Price> entityToModel(Set<PriceEntity> entities) {
    return entities.stream().map(
        entity -> {
          return entityToModel(entity);
        }
    ).collect(Collectors.toList());
  }
}
