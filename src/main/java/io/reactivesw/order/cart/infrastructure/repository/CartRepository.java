package io.reactivesw.order.cart.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

import javax.annotation.Resource;

import io.reactivesw.order.cart.infrastructure.enums.CartState;
import io.reactivesw.order.cart.domain.entity.CartEntity;
import org.springframework.stereotype.Repository;

/**
 * Created by umasuo on 16/11/29.
 */
@Repository
public interface CartRepository extends JpaRepository<CartEntity, String>,
    CrudRepository<CartEntity, String> {

  /**
   * find by customer id.
   *
   * @param customerId String
   * @return list of cart, but can contains one at most.
   */
  List<CartEntity> findByCustomerId(String customerId);

  /**
   * find the active cart by customer id.
   *
   * @param customerId String
   * @return list of cart, but can contains one at most.
   */
  List<CartEntity> findByCustomerIdAndCartState(String customerId, CartState cartState);

  /**
   * find the active cart by anonymous id.
   *
   * @param anonymousId String
   * @return cart
   */
  CartEntity findOneByAnonymousId(String anonymousId);

}
