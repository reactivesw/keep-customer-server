package io.reactivesw.order.cartdiscount.infrastructure.repository;

import io.reactivesw.order.cartdiscount.domain.entity.CartDiscountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by umasuo on 16/12/9.
 */
@Repository
public interface CartDiscountRepository extends JpaRepository<CartDiscountEntity, String>,
    CrudRepository<CartDiscountEntity, String> {
}
