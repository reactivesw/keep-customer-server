package io.reactivesw.catalog.producttype.infrastructure.repository;

import io.reactivesw.catalog.producttype.domain.entity.ProductTypeEntity;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Davis on 16/12/7.
 */
public interface ProductTypeRepository extends JpaRepository<ProductTypeEntity, String> {
  /**
   * Find distinct product type by key product type entity.
   *
   * @param key the key
   * @return the product type entity
   */
  ProductTypeEntity findDistinctProductTypeByKey(String key);
}
