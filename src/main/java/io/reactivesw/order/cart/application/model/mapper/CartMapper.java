package io.reactivesw.order.cart.application.model.mapper;

import io.reactivesw.order.cart.application.model.Cart;
import io.reactivesw.order.cart.application.model.CustomLineItem;
import io.reactivesw.order.cart.application.model.LineItem;
import io.reactivesw.order.cart.domain.entity.CartEntity;
import io.reactivesw.order.cart.domain.entity.value.CustomLineItemValue;
import io.reactivesw.order.cart.domain.entity.value.LineItemValue;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by umasuo on 16/12/5.
 */
public class CartMapper {
  /**
   * logger.
   */
  private static final Logger LOG = LoggerFactory.getLogger(CartMapper.class);

  /**
   * convert entity to model.
   *
   * @param entity CartEntity
   * @return Cart
   */
  public static Cart entityToModel(CartEntity entity) {
    Cart cart = new Cart();
    cart.setId(entity.getId());
    cart.setVersion(entity.getVersion());
    cart.setCreatedAt(entity.getCreatedAt());
    cart.setLastModifiedAt(entity.getLastModifiedAt());
    cart.setCustomerId(entity.getCustomerId());
    cart.setCustomerEmail(entity.getCustomerEmail());
    cart.setAnonymousId(entity.getAnonymousId());
    cart.setLineItems(getLineItems(entity.getLineItems()));
    cart.setCustomLineItems(getCustomLineItem(entity.getCustomLineItems()));
    cart.setCountry(entity.getCountry());
//    cart.setBillingAddress();
    //TODO finish entity to model.
    return cart;
  }


  /**
   * convert Cart to CartEntity.
   * TODO we may do not need this function.
   *
   * @param cart Cart
   * @return CartEntity.
   */
  public static CartEntity modelToEntity(Cart cart) {
    //TODO finish model to entity.
    return null;
  }

  /**
   * get lineItems.
   *
   * @param itemValues
   */
  private static List<LineItem> getLineItems(Set<LineItemValue> itemValues) {
    List<LineItem> items = new ArrayList<>();
    if (itemValues != null) {
      items = itemValues.parallelStream().map(item -> LineItemMapper.entityToModel(item))
          .collect(Collectors.toList());
    }
    return items;
  }

  /**
   * get custom line item.
   *
   * @param itemValues Set<CustomLineItemValue>
   * @return List<CustomLineItem>
   */
  private static List<CustomLineItem> getCustomLineItem(Set<CustomLineItemValue> itemValues) {
    List<CustomLineItem> items = new ArrayList<>();
    if (itemValues != null) {
      //TODO set the custom line items.
    }
    return items;
  }

}
