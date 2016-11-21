package io.reactivesw.customer.server.routes;

/**
 * router.
 * Created by BruceLiu on 16/11/14.
 */
public class Router {

  /*************** Customer. *****************/
  /**
   * customer id.
   */
  public static final String CUSTOMER_ID = "customerId";

  /**
   * create customer, sign up.
   */
  public static final String CUSTOMER_CREATE = "/customers/";

  /**
   * get customer by id.
   */
  public static final String CUSTOMER_GET_BY_ID = "/customers/{" + CUSTOMER_ID + "}";

  /*************** End Of Customer. *****************/

  /*************** Category. *****************/
  /**
   * for category.
   */
  public static final String CATEGORY_ALL = "categories";

  /**
   * categoryId.
   */
  public static final String CATEGORY_ID = "categoryId";

  /**
   * category url with id.
   */
  public static final String CATEGORIES_WITH_ID = CATEGORY_ALL + "/{" + CATEGORY_ID + "}";

  /*************** End Of Category. *****************/

}
