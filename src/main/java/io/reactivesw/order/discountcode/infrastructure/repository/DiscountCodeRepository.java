package io.reactivesw.order.discountcode.infrastructure.repository;

import io.reactivesw.order.discountcode.domain.entity.DiscountCodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by umasuo on 16/12/6.
 */
public interface DiscountCodeRepository extends JpaRepository<DiscountCodeEntity, String>, CrudRepository<DiscountCodeEntity, String> {
}
