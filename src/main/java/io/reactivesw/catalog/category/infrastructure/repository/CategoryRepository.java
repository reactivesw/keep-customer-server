package io.reactivesw.catalog.category.infrastructure.repository;

import io.reactivesw.catalog.category.domain.entity.CategoryEntity;

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
   * @param ancestorId the ancestorId
   * @return the list
   */
  @Query(value = "select c.id from CategoryEntity c where ?1 member of c.ancestors")
  List<String> queryCategoryIdsByAncestorId(String ancestorId);

  /**
   * Query category by parent list.
   *
   * @param parentId the parent id
   * @return the list
   */
  List<CategoryEntity> queryCategoryByParent(String parentId);

  /**
   * Delete category by id.
   *
   * @param Ids the ids
   */
  @Modifying
  @Transactional
  @Query(value = "delete from CategoryEntity c where c.id in ?1")
  void deleteCategoryById(List<String> Ids);

  /**
   * Find category by slug.
   *
   * @param slug the slug
   * @return the category entity
   */
  CategoryEntity findCategoryBySlug(String slug);
}