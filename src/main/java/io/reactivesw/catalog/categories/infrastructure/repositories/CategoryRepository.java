package io.reactivesw.catalog.categories.infrastructure.repositories;

import io.reactivesw.catalog.categories.domains.entities.CategoryEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by umasuo on 16/11/22.
 */
public interface CategoryRepository extends JpaRepository<CategoryEntity, String> , JpaSpecificationExecutor {
  /**
   * Query category ids by ancestor id list.
   *
   * @param ancestorId the ancestorid
   * @return the list
   */
  @Query(value = "select c.id from catalog_category c where JSON_CONTAINS(c.ancestors, ?1)",
      nativeQuery = true)
  List<String> queryCategoryIdsByAncestorId(String ancestorId);

  @Query(value = "select * from catalog_category where name->?1 = ?2",
  nativeQuery = true)
  List<CategoryEntity> queryCategoryByName(String langKey, String name);
}
