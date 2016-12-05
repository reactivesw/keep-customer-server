package io.reactivesw.orders.carts.domains.services;

import io.reactivesw.common.exceptions.AlreadyExistException;
import io.reactivesw.common.exceptions.NotExistException;
import io.reactivesw.common.exceptions.ParametersException;
import io.reactivesw.common.models.Statics;
import io.reactivesw.orders.carts.domains.entities.CartEntity;
import io.reactivesw.orders.carts.infrastructures.enums.CartState;
import io.reactivesw.orders.carts.infrastructures.repositories.CartRepository;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    return this.cartRepository.save(sample);
  }

  /**
   * get cart by cart Id.
   *
   * @param cartId String
   * @return CartEntity
   */
  public CartEntity getCartByCartId(String cartId) {
    LOG.debug("CartId:{}", cartId);
    CartEntity entity = this.cartRepository.findOne(cartId);

    if (entity == null) {
      throw new NotExistException("Cart not exist with id: " + cartId);
    }
    return this.cartRepository.findOne(cartId);
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
      //each customer should
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
   * update an entity
   *
   * @param cart CartEntity
   * @return CartEntity
   */
  public CartEntity updateCart(CartEntity cart) {
    return null;
  }

  /**
   * setter of the cart repository.
   *
   * @param cartRepository
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
}
