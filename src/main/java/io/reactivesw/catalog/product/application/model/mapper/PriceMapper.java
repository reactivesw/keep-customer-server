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
    entity.setChannel(model.getChannel().getId());
    entity.setValidFrom(model.getValidFrom());
    entity.setValidUntil(model.getValidUntil());
    entity.setCustomerGroup(model.getCustomerGroup().getId());
    entity.setCustom(CustomFieldsMapper.modelToEntity(model.getCustom()));

    return entity;
  }

  public static Price entityToModel(PriceEntity entity) {
    Price model = new Price();

    model.setChannel(new Reference(ReferenceTypes.CHANNEL.getType(), entity.getChannel()));
    model.setCountry(entity.getCountry());
    model.setId(entity.getId());
    model.setValidFrom(entity.getValidFrom());
    model.setValidUntil(entity.getValidUntil());
    model.setValue(MoneyMapper.entityToModel(entity.getValue()));
    model.setCustomerGroup(new Reference(ReferenceTypes.CUSTOMERGROUP.getType(), entity
        .getCustomerGroup()));
    // TODO: 16/12/14 discount should calculate
//    model.setDiscounted(DiscountedPriceMapper.entityToModel(entity.getDiscounted()));
    model.setCustom(entity.getCustom());

    return null;
  }

  public static List<Price> entityToModel(Set<PriceEntity> entities) {
    return entities.stream().map(
        entity -> {
          return entityToModel(entity);
        }
    ).collect(Collectors.toList());
  }
}
