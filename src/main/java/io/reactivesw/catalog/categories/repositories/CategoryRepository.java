package io.reactivesw.catalog.categories.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.reactivesw.catalog.categories.entities.CategoryEntity;

/**
 * Created by umasuo on 16/11/22.
 */
public interface CategoryRepository extends JpaRepository<CategoryEntity, String> {
}
