package io.reactivesw.catalog.categories.repositories;

import io.reactivesw.catalog.categories.entities.CategoryEntity;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by umasuo on 16/11/22.
 */
public interface CategoryRepository extends JpaRepository<CategoryEntity, String> {
}
