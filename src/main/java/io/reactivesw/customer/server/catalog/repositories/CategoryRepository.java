package io.reactivesw.customer.server.catalog.repositories;

import io.reactivesw.customer.server.catalog.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by rai on 16/11/13.
 */
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
  /**
   * Query id list by parent id list.
   *
   * @param id the id
   * @return the list
   */
  @Query("select c.id from CategoryEntity c where c.parentId in ?1")
  List<Integer> queryIdListByParentId(List<Integer> id);
}

