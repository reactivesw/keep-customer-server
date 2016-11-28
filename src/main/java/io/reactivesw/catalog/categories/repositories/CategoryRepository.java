package io.reactivesw.catalog.categories.repositories;

import io.reactivesw.catalog.categories.entities.CategoryEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by umasuo on 16/11/22.
 */
public interface CategoryRepository extends JpaRepository<CategoryEntity, String> {
  /**
   * Query category ids by ancestor id list.
   *
   * @param ancestorid the ancestorid
   * @return the list
   */
  @Query(value = "select c.id from catalog_category c where JSON_CONTAINS(c.ancestors, [ ?1 ])",
      nativeQuery = true)
  List<String> queryCategoryIdsByAncestorId(String ancestorid);
}
