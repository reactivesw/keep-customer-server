package io.reactivesw.order.shippingmethod.infrastructure.repository;

import io.reactivesw.order.shippingmethod.domain.entity.ShippingMethodEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by umasuo on 16/12/8.
 */
@Repository
public interface ShippingMethodRepository extends JpaRepository<ShippingMethodEntity, String>,
    CrudRepository<ShippingMethodEntity, String> {
}
