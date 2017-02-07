package io.reactivesw.order.order.application.model.mapper;

import io.reactivesw.order.cart.application.model.LineItem;
import io.reactivesw.order.order.domain.entity.value.LineItemValue;

import java.util.List;

/**
 * Created by Davis on 17/2/7.
 */
public final class LineItemMapper {
  /**
   * Instantiates a new Line item mapper.
   */
  private LineItemMapper() {
  }

  /**
   * Model to entity list.
   *
   * @param models the models
   * @return the list
   */
  public static List<LineItemValue> modelToEntity(List<LineItem> models) {
    return null;
  }

  /**
   * Model to entity line item value.
   *
   * @param model the model
   * @return the line item value
   */
  public static LineItemValue modelToEntity(LineItem model) {
    LineItemValue entity = new LineItemValue();

    // TODO: 17/2/7
    entity.setProductId(model.getProductId());
    entity.setName(null);
    entity.setProductSlug(null);
    entity.setVariant(null);
    entity.setPrice(null);
    entity.setTaxedPrice(null);
    entity.setTotalPrice(null);
    entity.setQuantity(model.getQuantity());
    entity.setState(null);
    entity.setTaxRate(null);

    String supplyChannel = model.getSupplyChannel() == null ? null : model.getSupplyChannel()
        .getId();
    entity.setSupplyChannel(supplyChannel);

    String distributionChannel = model.getDistributionChannel() == null ? null : model
        .getDistributionChannel().getId();
    entity.setDistributionChannel(distributionChannel);

    entity.setDiscountedPriceForQuantity(null);
    entity.setPriceMode(null);
    entity.setCustom(null);

    return entity;
  }
}
