package io.reactivesw.catalog.taxcategory.infrastructure.repository;

import io.reactivesw.catalog.taxcategory.domain.entity.TaxCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Davis on 16/12/10.
 */
public interface TaxCategoryRepository extends JpaRepository<TaxCategoryEntity, String> {
}
