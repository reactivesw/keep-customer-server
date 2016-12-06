package io.reactivesw.orders.discountcodes.repositories;

import io.reactivesw.orders.discountcodes.domains.entities.DiscountCodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by umasuo on 16/12/6.
 */
public interface DiscountCodeRepository extends JpaRepository<DiscountCodeEntity, String>, CrudRepository<DiscountCodeEntity, String> {
}
