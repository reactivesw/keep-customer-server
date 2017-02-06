package io.reactivesw.order.cart.domain.service;

import io.reactivesw.common.exception.*;
import io.reactivesw.order.cart.domain.entity.CartEntity;
import io.reactivesw.order.cart.infrastructure.enums.CartState;
import io.reactivesw.order.cart.infrastructure.repository.CartRepository;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
    LOG.debug("subjectId:{}", customerId);

    List<CartEntity> result = this.cartRepository.findByCustomerIdAndCartState(customerId,
        CartState.Active);
    Optional<CartEntity> op = result.parallelStream().findAny();

    CartEntity entity;
    if (op.isPresent()) {
      //each customer should have one
      entity = op.get();
    } else {
      entity = this.createActiveCartWithCustomerId(customerId);
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
  public CartEntity getCartByAnonymousId(String anonymousId) {
    LOG.debug("anonymousId:{}", anonymousId);

    CartEntity result = this.cartRepository.findOneByAnonymousId(anonymousId);

    if (result == null) {
      result = this.createActiveCartWithAnonymousId(anonymousId);
    }

    return result;
  }

  /**
   * update cart for with action list.
   *
   * @param id         String of cart id
   * @param version    Integer
   * @param cartEntity CartEntity
   * @return CartEntity
   */
  @Transactional
  public CartEntity updateCart(String id, Integer version, CartEntity cartEntity) {
    CartEntity cart = this.getById(id);

    this.checkVersion(version, cart.getVersion());

    if (cart.getCartState() != CartState.Active) {
      LOG.debug("Only active Cart can be changed, id:{}", id);
      throw new ImmutableException("Only active Cart can be changed");
    }

    return this.cartRepository.save(cartEntity);
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
    entity.setCurrencyCode("USD");
    CartEntity retEntity = cartRepository.save(entity);
    LOG.info("Create a new active cart with subjectId:{}, entity:{}", customerId, retEntity
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
    LOG.debug("enter, anonymousId: {}", anonymousId);

    CartEntity entity = new CartEntity();
    entity.setAnonymousId(anonymousId);
    entity.setCartState(CartState.Active);
    entity.setCurrencyCode("USD");
    CartEntity retEntity = cartRepository.save(entity);

    LOG.debug("Create a new active cart with anonymousId:{}, entity:{}", anonymousId, retEntity
        .toString());
    return retEntity;
  }

  /**
   * delete cart.
   *
   * @param id      String
   * @param version Integer
   */
  @Transactional
  public void deleteCart(String id, Integer version) {
    LOG.debug("enter, id: {}, version: {}", id, version);
    CartEntity cart = this.getById(id);

    this.checkVersion(version, cart.getVersion());

    if (cart.getCartState() != CartState.Active) {
      LOG.debug("Only active Cart can be changed, id:{}", id);
      throw new ImmutableException("Only active Cart can be changed");
    }

    this.cartRepository.delete(id);
  }

  /**
   * check the version of the discount.
   *
   * @param inputVersion Integer
   * @param savedVersion Integer
   */
  private void checkVersion(Integer inputVersion, Integer savedVersion) {
    if (!Objects.equals(inputVersion, savedVersion)) {
      LOG.debug("Cart version is not correct. inputVersion:{}, savedVersion:{}",
          inputVersion, savedVersion);
      throw new ConflictException("Cart version is not correct.");
    }
  }
}
