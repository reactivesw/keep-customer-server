package io.reactivesw.order.order.infrastructure.repository;

import io.reactivesw.order.order.domain.entity.OrderEntity;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Davis on 17/2/4.
 */
public interface OrderRepository extends JpaRepository<OrderEntity, String>{
}
