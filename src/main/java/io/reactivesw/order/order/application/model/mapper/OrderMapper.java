package io.reactivesw.order.order.application.model.mapper;

import com.google.common.collect.Lists;

import io.reactivesw.common.enums.ReferenceTypes;
import io.reactivesw.common.model.Reference;
import io.reactivesw.common.model.mapper.MoneyMapper;
import io.reactivesw.order.cart.application.model.Cart;
import io.reactivesw.order.order.application.model.Order;
import io.reactivesw.order.order.domain.entity.OrderEntity;
import io.reactivesw.order.order.infrastructure.enums.OrderState;
import io.reactivesw.order.payment.application.model.Payment;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by Davis on 17/2/6.
 */
public final class OrderMapper {
  /**
   * Instantiates a new Order mapper.
   */
  private OrderMapper() {
  }


  /**
   * Of order entity.
   *
   * @param cart    the cart
   * @param payment the payment
   * @return the order entity
   */
  public static OrderEntity of(Cart cart, Payment payment) {
    OrderEntity entity = new OrderEntity();

    // TODO: 17/2/6
    entity.setCompletedAt(null);
    entity.setOrderName(null);
    entity.setCustomerId(cart.getCustomerId());
    entity.setCustomerEmail(null);
    entity.setAnonymousId(cart.getAnonymousId());
    entity.setLineItems(null);
    entity.setTotalPrice(MoneyMapper.modelToEntity(cart.getTotalPrice()));
    entity.setTaxedPrice(TaxedPriceMapper.modelToEntity(cart.getTaxedPrice()));
    entity.setShippingAddress(ShippingAddressMapper.modelToEntity(cart.getShippingAddress()));
    entity.setBillingAddress(BillingAddressMapper.modelToEntity(cart.getBillingAddress()));
    entity.setTaxMode(cart.getTaxMode());
    if (cart.getCustomerGroup() != null && StringUtils.isNotBlank(cart.getCustomerGroup().getId()
    )) {
      entity.setCustomerGroup(cart.getCustomerGroup().getId());
    }
    entity.setCountry(cart.getCountry());
    entity.setOrderState(OrderState.Complete);
    entity.setShippingInfo(ShippingInfoMapper.modelToEntity(cart.getShippingInfo()));
    entity.setDiscountCodes(null);
    entity.setCustom(null);
    entity.setPaymentInfo(Lists.newArrayList(payment.getId()));
    entity.setLocale(null);

    return entity;
  }

  /**
   * Entity to model order.
   *
   * @param entity the entity
   * @return the order
   */
  public static Order entityToModel(OrderEntity entity) {
    Order model = new Order();

    model.setId(entity.getId());
    model.setVersion(entity.getVersion());
    model.setCreatedAt(entity.getCreatedAt());
    model.setLastModifiedAt(entity.getLastModifiedAt());
    model.setCompletedAt(entity.getCompletedAt());
    model.setOrderNumber(entity.getOrderName());
    model.setCustomerId(entity.getCustomerId());
    model.setCustomerEmail(entity.getCustomerEmail());
    model.setAnonymousId(entity.getAnonymousId());
    model.setLineItems(null);
    model.setTotalPrice(MoneyMapper.entityToModel(entity.getTotalPrice()));
    model.setTaxedPrice(TaxedPriceMapper.entityToModel(entity.getTaxedPrice()));
    model.setTaxMode(entity.getTaxMode());
    model.setCustomerGroup(new Reference(ReferenceTypes.CUSTOMERGROUP.toString(), entity
        .getCustomerGroup()));
    model.setCountry(entity.getCountry());
    model.setOrderState(entity.getOrderState());
    model.setState(null);
    model.setShipmentState(null);
    model.setShippingInfo(ShippingInfoMapper.entityToModel(entity.getShippingInfo()));
    model.setSyncInfo(null);
    model.setReturnInfo(null);
    model.setDiscountCodes(null);
    model.setLastMessageSequenceNumber(null);
    model.setCart(null);
    model.setCustom(null);
    model.setPaymentInfo(null);
    model.setLocale(entity.getLocale());
    model.setInventoryMode(null);

    return model;
  }

}
