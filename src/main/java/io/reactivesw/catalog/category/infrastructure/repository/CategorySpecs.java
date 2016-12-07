package io.reactivesw.catalog.category.infrastructure.repository;

import io.reactivesw.catalog.category.domain.entities.CategoryEntity;
import io.reactivesw.common.model.QueryConditions;
import io.reactivesw.common.specification.PredicateSpecs;
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
        String where = queryConditions.getWhere();
        Predicate[] predicates = PredicateSpecs.toPredicates(root, cb, where);
        Predicate predicate = null;

        if (where.contains("or")) {
          predicate = cb.or(predicates);
        }else {
          predicate = cb.and(predicates);
        }

        return query.where(predicate).getRestriction();

//        String whereConditions = queryConditions.getWhere();
//        Predicate versionCondition = cb.equal(root.get("version"), 0);
//        Predicate ancestorCondition = cb.like(root.get("ancestrosString"), "%first%");
//        Join<CategoryEntity, LocalizedStringEntity> join = root.join("name");
//        Predicate languageCondition = cb.equal(join.get("language"), "en");
//        Predicate textCondition = cb.equal(join.get("text"), "en value");


//        Order sortText = cb.desc(join.get("text"));

//        Order sortCondition = cb.asc(root.get("version"));
//        Order sortCondition = cb.desc(root.get("version"));
//        Order sortCondition = cb.asc(root.get("name"));


//        return query
////            .where(versionCondition)
////            .where(ancestorCondition)
//            .where(languageCondition)
////            .where(textCondition)
//            .orderBy(sortText)
//            .getRestriction();
      }
    };
  }
}