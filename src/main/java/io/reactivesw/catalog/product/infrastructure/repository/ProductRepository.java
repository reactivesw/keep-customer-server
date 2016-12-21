package io.reactivesw.catalog.product.infrastructure.repository;

import io.reactivesw.catalog.product.domain.entity.ProductEntity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Davis on 16/12/14.
 */
public interface ProductRepository extends JpaRepository<ProductEntity, String>{
}
