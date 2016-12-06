package io.reactivesw.orders.carts.applications.models.mapper;

import io.reactivesw.orders.carts.applications.models.Cart;
import io.reactivesw.orders.carts.applications.models.CustomLineItem;
import io.reactivesw.orders.carts.applications.models.LineItem;
import io.reactivesw.orders.carts.domains.entities.CartEntity;
import io.reactivesw.orders.carts.domains.entities.values.CustomLineItemValue;
import io.reactivesw.orders.carts.domains.entities.values.LineItemValue;
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
  private static final Logger LOG = LoggerFactory.getLogger(CartMapper.class);

  /**
   * model mapper.
   */
  private static ModelMapper mapper = new ModelMapper();

  /**
   * convert entity to model.
   *
   * @param entity CartEntity
   * @return Cart
   */
  public static Cart convertEntityToModel(CartEntity entity) {
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

    return cart;
  }

  /**
   * get lineItems.
   *
   * @param itemValues
   */
  private static List<LineItem> getLineItems(Set<LineItemValue> itemValues) {
    List<LineItem> items = new ArrayList<>();
    if (itemValues != null) {
      items = itemValues.parallelStream().map(item -> LineItemMapper.convertEntityToModel(item))
          .collect(Collectors.toList());
    }
    return items;
  }

  private static List<CustomLineItem> getCustomLineItem(Set<CustomLineItemValue> itemValues) {
    List<CustomLineItem> items = new ArrayList<>();
    if (itemValues != null) {
//      items = itemValues.parallelStream().map()
    }
    return items;
  }

}
