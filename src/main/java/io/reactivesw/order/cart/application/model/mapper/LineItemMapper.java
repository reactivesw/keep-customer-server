package io.reactivesw.order.cart.application.model.mapper;

import io.reactivesw.order.cart.application.model.LineItemDraft;
import io.reactivesw.order.cart.domain.entity.value.LineItemValue;

/**
 * Created by umasuo on 16/12/5.
 */
public class LineItemMapper {

  /**
   * convert model to entity.
   *
   * @param model LineItemDraft
   * @return LineItemValue
   */
  public static LineItemValue modelToEntity(LineItemDraft model) {
    LineItemValue entity = null;
    if (model != null) {
      entity = new LineItemValue();
      entity.setProductId(model.getProductId());

      entity.setQuantity(model.getQuantity());

      entity.setVariant(model.getVariantId());

      String supplyChannel = model.getSupplyChannel() == null ? null : model.getSupplyChannel()
          .getId();
      entity.setSupplyChannel(supplyChannel);

      String distributionChannel = model.getDistributionChannel() == null ? null : model
          .getDistributionChannel().getId();
      entity.setDistributionChannel(distributionChannel);
    }

    return entity;
  }

}
