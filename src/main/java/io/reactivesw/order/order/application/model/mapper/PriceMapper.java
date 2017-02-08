package io.reactivesw.order.order.application.model.mapper;

import io.reactivesw.catalog.product.application.model.Price;
import io.reactivesw.common.enums.ReferenceTypes;
import io.reactivesw.common.model.Reference;
import io.reactivesw.common.model.mapper.MoneyMapper;
import io.reactivesw.order.order.domain.entity.value.PriceValue;

/**
 * Created by Davis on 17/2/7.
 */
public final class PriceMapper {
  /**
   * Instantiates a new Price mapper.
   */
  private PriceMapper() {
  }

  /**
   * Model to entity price value.
   *
   * @param model the model
   * @return the price value
   */
  public static PriceValue modelToEntity(Price model) {
    PriceValue entity = new PriceValue();

    if (model != null) {
      entity.setValue(MoneyMapper.modelToEntity(model.getValue()));
      entity.setCountry(model.getCountry());
      if (model.getCustomerGroup() != null) {
        entity.setCustomerGroup(model.getCustomerGroup().getId());
      }
      if (model.getChannel() != null) {
        entity.setChannel(model.getChannel().getId());
      }
      entity.setValidFrom(model.getValidFrom());
      entity.setValidUntil(model.getValidUntil());
      entity.setDiscounted(model.getDiscounted());
      entity.setCustom(model.getCustom());
    }

    return entity;
  }

  /**
   * Entity to model price.
   *
   * @param entity the entity
   * @return the price
   */
  public static Price entityToModel(PriceValue entity) {
    Price model = new Price();

    if (entity != null) {
      model.setId(entity.getId());
      model.setValue(MoneyMapper.entityToModel(entity.getValue()));
      model.setCountry(entity.getCountry());
      model.setCustomerGroup(new Reference(
          ReferenceTypes.CUSTOMERGROUP.toString(), entity.getCustomerGroup()));
      model.setChannel(new Reference(
          ReferenceTypes.CHANNEL.toString(), entity.getChannel()
      ));
      model.setValidFrom(entity.getValidFrom());
      model.setValidUntil(entity.getValidUntil());
      model.setDiscounted(entity.getDiscounted());
      model.setCustom(entity.getCustom());
    }

    return model;
  }
}
