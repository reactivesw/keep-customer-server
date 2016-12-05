package io.reactivesw.catalog.categories.infrastructure.repositories;

import io.reactivesw.catalog.categories.domains.entities.CategoryEntity;
import io.reactivesw.common.entities.LocalizedStringEntity;
import io.reactivesw.common.models.QueryConditions;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Created by Davis on 16/11/28.
 */
public class CategorySpecs {
  public static Specification<CategoryEntity> equalsToVersion(Integer version) {
    return new Specification<CategoryEntity>() {
      public Predicate toPredicate(Root<CategoryEntity> root, CriteriaQuery<?> query,
                                   CriteriaBuilder builder) {

        return builder.equal(root.get("version"), version);
      }
    };
  }

  public static Specification<CategoryEntity> queryPredicate(QueryConditions queryConditions) {
    return new Specification<CategoryEntity>() {
      @Override
      public Predicate toPredicate(Root<CategoryEntity> root, CriteriaQuery<?> query,
                                   CriteriaBuilder cb) {
//        String whereConditions = queryConditions.getWhere();
        return null;
      }
    };
  }
}