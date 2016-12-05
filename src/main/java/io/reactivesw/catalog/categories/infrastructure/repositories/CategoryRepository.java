package io.reactivesw.catalog.categories.infrastructure.repositories;

import io.reactivesw.catalog.categories.domains.entities.CategoryEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by umasuo on 16/11/22.
 */
public interface CategoryRepository extends JpaRepository<CategoryEntity, String>,
    JpaSpecificationExecutor {
  /**
   * Query category ids by ancestor id list.
   *
   * @param ancestorId the ancestorid
   * @return the list
   */
  @Query(value = "select c.id from catalog_category c where c.ancestors > ?1\\:\\:jsonb",
      nativeQuery = true)
  List<String> queryCategoryIdsByAncestorId(String ancestorId);

  List<CategoryEntity> queryCategoryByParent(String parentId);

  @Modifying
  @Transactional
  @Query(value = "delete from CategoryEntity c where c.id in ?1")
  void deleteCategoryById(List<String> Ids);
}
