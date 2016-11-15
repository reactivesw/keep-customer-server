package io.reactivesw.customer.server.routes;

/**
 * Created by bruceliu on 16/11/14.
 */
public class Router {
  /**
   * test api.
   */
  public static final String TEST_API = "/test";
  /**
   * customer id.
   */
  public static final String CUSTOMER_ID = "customerId";

  /**
   * for customer apis.
   */
  public static final String CUSTOMER_GET_BY_ID = "/customers/{" + CUSTOMER_ID + "}";

  /**
   * for category.
   */
  public static final String CATEGORY_ALL = "/categories";
  /**
   * categoryId.
   */
  public static final String CATEGORY_ID = "categoryId";
  /**
   * category url with id.
   */
  public static final String CATEGORY_GET_BY_ID = CATEGORY_ALL + "/{" + CATEGORY_ID + "}";
}
