package io.reactivesw.route;

/**
 * router.
 * Created by BruceLiu on 16/11/14.
 */
public class Router {

  /**
   * The constant URL_ROOT.
   */
  public static final String URL_ROOT = "";


  /*************** Customer. *****************/
  /**
   * customer id.
   */
  public static final String CUSTOMER_ID = "customerId";


  /*************** End Of Customer. *****************/

  /*************** CategoryEntity. *****************/

  /**
   * The constant CATEGORY_ROOT.
   */
  public static final String CATEGORY_ROOT = URL_ROOT + "/category";

  /**
   * categoryId.
   */
  public static final String CATEGORY_ID = "categoryId";

  /**
   * category url with id.
   */
  public static final String CATEGORY_WITH_ID = CATEGORY_ROOT + "/{" + CATEGORY_ID + "}";

  /*************** End Of CategoryEntity. *****************/

  /*************** Product Type. **************************/

  /**
   * root url of product type.
   */
  public static final String PRODUCT_TYPE_ROOT = URL_ROOT + "/product-types";

  /**
   * product type id.
   */
  public static final String PRODUCT_TYPE_ID = "productTypeId";

  /**
   * product type key.
   */
  public static final String PRODUCT_TYPE_KEY = "productTypeKey";

  /**
   * product type url with id.
   */
  public static final String PRODUCT_TYPE_WITH_ID = PRODUCT_TYPE_ROOT
      + "/{" + PRODUCT_TYPE_ID + "}";

  /*************** End Product Type. **********************/


  /*************** Cart & order. *****************/
  /**
   * root url of cart.
   */
  public static final String CARTS_ROOT = URL_ROOT + "cart";

  /**
   * cart id.
   */
  public static final String CART_ID = "cartId";

  /**
   * get cart by id.
   */
  public static final String CART_WITH_ID = CARTS_ROOT + "/{" + CART_ID + "}";

  /*************** End of Cart & order. *****************/

}