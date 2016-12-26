package io.reactivesw.catalog.product.infrastructure.utils;

import io.reactivesw.common.model.QueryConditions;

/**
 * Created by Davis on 16/12/22.
 */
public final class QueryConditionUtils {

  /**
   * Instantiates a new Query condition utils.
   */
  private QueryConditionUtils() {}

  /**
   * Gets category id.
   *
   * @param queryConditions the query conditions
   * @return the category id
   * TODO only for categoryId, example: categoryId:"2222201-1111111"
   */
  public static String getCategoryId(QueryConditions queryConditions) {
    String where = queryConditions.getWhere();
    String[] conditions = where.split(":");
    return conditions[conditions.length - 1].replaceAll("\"", "");
  }
}
