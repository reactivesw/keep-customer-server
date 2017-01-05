package io.reactivesw.customer.customer.infrastructure.repository;

import io.reactivesw.customer.customer.domain.entity.AddressValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by umasuo on 17/1/05.
 */
public interface AddressRepository extends JpaRepository<AddressValue, String>,
    CrudRepository<AddressValue, String> {

}
