package io.reactivesw.order.cart.domain.service;

import io.reactivesw.common.exception.AlreadyExistException;
import io.reactivesw.common.exception.NotExistException;
import io.reactivesw.common.exception.ParametersException;
import io.reactivesw.common.model.Statics;
import io.reactivesw.order.cart.domain.entity.CartEntity;
import io.reactivesw.order.cart.domain.entity.value.LineItemValue;
import io.reactivesw.order.cart.infrastructure.enums.CartState;
import io.reactivesw.order.cart.infrastructure.repository.CartRepository;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Created by umasuo on 16/11/29.
 */
@Service
public class CartService {
  /**
   * logger.
   */
  private static final Logger LOG = LoggerFactory.getLogger(CartService.class);

  /**
   * cart repository.
   */
  @Autowired
  private transient CartRepository cartRepository;

  /**
   * Line item service.
   */
//  @Autowired
//  private transient LineItemService lineItemService;

  /**
   * Create an new active cart with sample.
   * Either customer id or anonymous id must be set.
   * Each customer(include anonymous customer) can only have one active cart.
   * If the customer already has an cart, then throw exception.
   *
   * @param sample CartEntity
   * @return CartEntity
   */
  public CartEntity createActiveCartWithSample(CartEntity sample) {
    String customerId = sample.getCustomerId();
    String anonymousId = sample.getAnonymousId();

    if (StringUtils.isBlank(customerId) && StringUtils.isBlank(anonymousId)) {
      throw new ParametersException("Either customer id or anonymous id must be set.");
    }

    List<CartEntity> result = null;
    if (StringUtils.isNotBlank(customerId)) {
      result = this.cartRepository.findByCustomerIdAndCartState(anonymousId,
          CartState.Active);
    } else if (StringUtils.isNotBlank(anonymousId)) {
      result = this.cartRepository.findByCustomerIdAndCartState(anonymousId,
          CartState.Active);
    }

    if (result != null && !result.isEmpty()) {
      throw new AlreadyExistException("The customer already has an active cart. ");
    }

    //TODO recalculate the cart
    return this.cartRepository.save(sample);
  }

  /**
   * get cart by cart Id.
   *
   * @param cartId String
   * @return CartEntity
   */
  public CartEntity getById(String cartId) {
    LOG.debug("CartId:{}", cartId);
    CartEntity entity = this.cartRepository.findOne(cartId);

    if (entity == null) {
      throw new NotExistException("Cart not exist with id: " + cartId);
    }
    return entity;
  }

  /**
   * get cart by customer id and cart state.
   *
   * @param customerId String
   * @param state      CartState
   * @return CartEntity
   */
  public List<CartEntity> getCartByCustomerIdAndState(String customerId, CartState state) {
    return this.cartRepository.findByCustomerIdAndCartState(customerId, state);
  }

  /**
   * Get cart by customer id and cart state.
   * Each customer(include the anonymous customer) can only have one active cart.
   * If can not find one, then create it.
   *
   * @param customerId String
   * @return CartEntity
   */
  public CartEntity getActiveCartByCustomerId(String customerId) {
    LOG.debug("customerId:{}", customerId);

    List<CartEntity> result = this.cartRepository.findByCustomerIdAndCartState(customerId,
        CartState.Active);
    CartEntity entity;
    if (result.isEmpty()) {
      //each customer should have one
      entity = this.createActiveCartWithCustomerId(customerId);
    } else {
      entity = result.get(Statics.FIRST_VALUE_IN_ARRAY);
    }

    return entity;
  }

  /**
   * Get cart by anonymous id and cart state.
   * Each customer(include the anonymous customer) can only have one active cart.
   * If can not find one, then create it.
   *
   * @param anonymousId String
   * @return CartEntity
   */
  public CartEntity getActiveCartByAnonymousId(String anonymousId) {
    LOG.debug("anonymousId:{}", anonymousId);

    List<CartEntity> result = this.cartRepository.findByCustomerIdAndCartState(anonymousId,
        CartState.Active);
    CartEntity entity;
    if (result.isEmpty()) {
      entity = this.createActiveCartWithAnonymousId(anonymousId);
    } else {
      entity = result.get(Statics.FIRST_VALUE_IN_ARRAY);
    }
    return entity;
  }

  /**
   * Update cart.
   * add line Item to the cart.
   * Adds a product variant in the given quantity to the cart. If the cart already contains the
   * product variant for the given supply and distribution channel, then only quantity of the
   * LineItem is increased.
   *
   * @param cartId   String
   * @param lineItem LineItemDraft
   * @return CartEntity
   */
  public CartEntity addLineItem(String cartId, LineItemValue lineItem) {
    CartEntity entity = this.getById(cartId);
    Set<LineItemValue> lineItems = entity.getLineItems();
    Optional<LineItemValue> item = lineItems.stream().filter(tmpItem -> tmpItem.equals(lineItem))
        .findFirst();

    if (item.isPresent()) {
      LineItemValue itemValue = item.get();
      itemValue.setQuantity(itemValue.getQuantity() + lineItem.getQuantity());
    } else {
      lineItems.add(lineItem);
    }
    //TODO recalculate the cart
    return this.cartRepository.save(entity);
  }

  /**
   * Decreases the quantity of the given LineItem. If after the update the quantity of the line
   * item is not greater than 0 or the quantity is not specified, the line item is removed from
   * the cart.
   *
   * @param cartId     String
   * @param lineItemId String Id of an existing LineItem in the cart.
   * @param quantity   int
   * @return CartEntity
   */
  public CartEntity removeLineItem(String cartId, String lineItemId, Integer quantity) {
    CartEntity entity = this.getById(cartId);
    Set<LineItemValue> lineItems = entity.getLineItems();
    Optional<LineItemValue> item = lineItems.stream().filter(tmpItem -> tmpItem.getId()
        == lineItemId).findFirst();
    if (!item.isPresent()) {
      throw new NotExistException("Removing not existing line item.");
    }
    LineItemValue itemValue = item.get();
    if (quantity == null || itemValue.getQuantity() >= quantity) {
      lineItems.remove(itemValue);
    } else {
      Integer remainQuantity = itemValue.getQuantity() - quantity;
      itemValue.setQuantity(remainQuantity);
    }
    //TODO calculate price
    return this.cartRepository.save(entity);
  }


  /**
   * setter of the cart repository.
   *
   * @param cartRepository CartRepository
   */
  protected void setCartRepository(CartRepository cartRepository) {
    this.cartRepository = cartRepository;
  }

  /**
   * Create an new cart with customer id.
   * This function should only be called by system, not by customer.
   *
   * @param customerId String
   * @return CartEntity
   */
  private CartEntity createActiveCartWithCustomerId(String customerId) {
    CartEntity entity = new CartEntity();
    entity.setCustomerId(customerId);
    entity.setCartState(CartState.Active);
    CartEntity retEntity = cartRepository.save(entity);
    LOG.info("Create a new active cart with customerId:{}, entity:{}", customerId, retEntity
        .toString());
    return retEntity;
  }

  /**
   * create an new cart with anonymous id.
   * This function should only be called by system, not by customer.
   *
   * @param anonymousId String
   * @return CartEntity
   */
  private CartEntity createActiveCartWithAnonymousId(String anonymousId) {
    CartEntity entity = new CartEntity();
    entity.setAnonymousId(anonymousId);
    entity.setCartState(CartState.Active);
    CartEntity retEntity = cartRepository.save(entity);
    LOG.info("Create a new active cart with anonymousId:{}, entity:{}", anonymousId, retEntity
        .toString());
    return retEntity;
  }

  /**
   * calculate cart price.
   *
   * @param cart CartEntity
   */
//  private void calculateCartPrice(CartEntity cart) {
//    //first, get all product price and get a sum, do the same to shipping method
//    //second, get all cart discounts that match this cart, if needed, we also need to get all
//    // discount code.
//    //third, calculate the cart price
//    MoneyEntity totalPrice = cart.getTotalPrice();
//    cart.getLineItems().parallelStream().forEach(
//        lineItemValue -> {
//          lineItemService.calculateTotalPrice(lineItemValue);
//          totalPrice.setCentAmount(
//              totalPrice.getCentAmount() + lineItemValue.getTotalPrice().getCentAmount()
//          );
//        }
//    );
//
//  }

}
