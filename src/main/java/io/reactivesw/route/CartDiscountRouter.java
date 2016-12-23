package io.reactivesw.route;

/**
 * Created by umasuo on 16/12/20.
 */
public class CartDiscountRouter extends BaseRouter {
  /**
   * root url of cart.
   */
  public static final String CART_DISCOUNT_ROOT = URL_ROOT + "cart-discounts";

  /**
   * cart id.
   */
  public static final String CART_DISCOUNT_ID = "ID";

  /**
   * id pattern.
   */
  public static final String ID_PATTERN = "{" + CART_DISCOUNT_ID + "}";

  /**
   * get cart by id.
   */
  public static final String CART_DISCOUNT_WITH_ID = CART_DISCOUNT_ROOT + "/" + ID_PATTERN;

  /**
   * searches, this used for search.
   */
  public static final String CART_DISCOUNT_SEARCH = CART_DISCOUNT_ROOT + "/" + SEARCH;

}
