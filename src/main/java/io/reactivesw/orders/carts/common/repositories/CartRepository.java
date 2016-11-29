package io.reactivesw.orders.carts.common.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

import io.reactivesw.orders.carts.common.enums.CartState;
import io.reactivesw.orders.carts.domain.entities.CartEntity;

/**
 * Created by umasuo on 16/11/29.
 */
public interface CartRepository extends JpaRepository<CartEntity, String>, CrudRepository<CartEntity, String> {

  /**
   * find by customer id.
   *
   * @param customerId String
   * @return list of cart, but can contains one at most.
   */
  public List<CartEntity> findByCustomerId(String customerId);

  /**
   * find the active cart by customer id.
   *
   * @param customerId String
   * @return list of cart, but can contains one at most.
   */
  public List<CartEntity> findByCustomerIdAndCartState(String customerId, CartState cartState);

}
