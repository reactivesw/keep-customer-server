package io.reactivesw.customer.server.catalog.repositories;

import io.reactivesw.customer.server.catalog.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by rai on 16/11/13.
 */
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
}

