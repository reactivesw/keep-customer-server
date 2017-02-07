package io.reactivesw.order.order.application.model.mapper;

import io.reactivesw.catalog.product.application.model.Price;
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

    return entity;
  }
}