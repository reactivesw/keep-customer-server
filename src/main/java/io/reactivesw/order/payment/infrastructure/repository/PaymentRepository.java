package io.reactivesw.order.payment.infrastructure.repository;

import io.reactivesw.order.payment.domain.entity.PaymentEntity;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Davis on 17/2/4.
 */
public interface PaymentRepository extends JpaRepository<PaymentEntity, String> {
}
