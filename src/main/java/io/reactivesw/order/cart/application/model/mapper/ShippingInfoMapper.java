package io.reactivesw.order.cart.application.model.mapper;

import io.reactivesw.catalog.productdiscount.model.mapper.DiscountedPriceMapper;
import io.reactivesw.common.enums.ReferenceTypes;
import io.reactivesw.common.model.Reference;
import io.reactivesw.common.model.mapper.MoneyMapper;
import io.reactivesw.order.cart.application.model.ShippingInfo;
import io.reactivesw.order.cart.domain.entity.value.ShippingInfoValue;

/**
 * Created by umasuo on 16/12/26.
 */
public class ShippingInfoMapper {

  public static ShippingInfo entityToModel(ShippingInfoValue entity) {
    ShippingInfo value = null;
    if (entity != null) {
      value = new ShippingInfo();
      value.setShippingMethodName(entity.getShippingMethodName());
      value.setPrice(MoneyMapper.entityToModel(entity.getPrice()));
      value.setShippingRate(ShippingRateMapper.entityToModel(entity.getShippingRate()));
      value.setTaxedPrice(TaxedItemPriceMapper.entityToModel(entity.getTaxedPrice()));
      value.setTaxRate(TaxRateMapper.entityToModel(entity.getTaxRate()));
      value.setTaxCategory(new Reference(ReferenceTypes.TAXCATEGORY.getType(), entity
          .getTaxCategory()));
      value.setShippingMethod(new Reference(ReferenceTypes.SHIPPING_METHOD.getType(), entity
          .getShippingMethod()));

//      value.setDiscountedPrice(DiscountedPriceMapper.entityToModel(entity.getDiscountedPrice()));
    }
    return value;
  }
}
