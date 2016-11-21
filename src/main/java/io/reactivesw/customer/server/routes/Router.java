package io.reactivesw.customer.server.routes;

/**
 * router.
 * Created by BruceLiu on 16/11/14.
 */
public class Router {

  public static final String URL_ROOT = "/{projectKey}/";


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
  public static final String CATEGORY_ROOT = "/categories";

  /**
   * categoryId.
   */
  public static final String CATEGORY_ID = "categoryId";

  /**
   * category url with id.
   */
  public static final String CATEGORY_GET_BY_ID = CATEGORY_ROOT + "/{" + CATEGORY_ID + "}";

  /*************** End Of Category. *****************/


  /*************** Cart & order. *****************/
  /**
   * root url of carts.
   */
  public static final String CARTS_ROOT = URL_ROOT + "carts";

  /**
   * cart id.
   */
  public static final String CART_ID = "cartId";

  /**
   * get cart by id.
   */
  public static final String CART_GET_BY_ID = CARTS_ROOT + "/{" +CART_ID + "}";

  /*************** End of Cart & order. *****************/

}
