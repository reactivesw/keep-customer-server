package io.reactivesw.order.cart.application.model.mapper;

import io.reactivesw.common.model.mapper.LocalizedStringMapper;
import io.reactivesw.order.cart.application.model.LineItem;
import io.reactivesw.order.cart.domain.entity.value.LineItemValue;

/**
 * Created by umasuo on 16/12/5.
 */
public class LineItemMapper {

  /**
   * convert entity to model.
   *
   * @param entity LineItemValue
   * @return LineItem
   */
  public static LineItem convertEntityToModel(LineItemValue entity) {
    LineItem item = new LineItem();
    item.setId(entity.getId());

    item.setProductId(entity.getProductId());

    item.setName(LocalizedStringMapper.entityToModelDefaultNew(entity.getName()));

    item.setProductSlug(LocalizedStringMapper.entityToModelDefaultNew(entity.getProductSlug()));

//    private ProductVariant variant;
//
//    private Price price;
//
//    private TaxedItemPrice taxedPrice;
//
//    private Money totalPrice;
//
//    private Integer quantity;
//
//    private List<ItemState> state;
//
//    private TaxRate taxRate;
//
//    private Reference supplyChannel;
//
//    private Reference distributionChannel;
//
//    private List<DiscountedLineItemPriceForQuantity> discountedPricePerQuantity;
//
//    private LineItemPriceMode priceMode;
//
//    private CustomFields custom;

    return item;
  }

}
