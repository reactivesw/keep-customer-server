package io.reactivesw.customer.customer.infrastructure.repository;

import io.reactivesw.customer.customer.domain.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by umasuo on 16/12/26.
 */
public interface CustomerRepository extends JpaRepository<CustomerEntity, String>,
    CrudRepository<CustomerEntity, String> {

  CustomerEntity findOneByCustomerName(String customerName);

  CustomerEntity findOneByEmail(String email);
}
