package io.reactivesw.route;

/**
 * Created by umasuo on 16/12/20.
 */
public class CartRouter extends BaseRouter {
  /**
   * root url of cart.
   */
  public static final String CARTS_ROOT = URL_ROOT + "cart";

  /**
   * cart id.
   */
  public static final String CART_ID = "cartId";

  /**
   *  id pattern.
   */
  public static final String ID_PATTERN = "{" + CART_ID + "}";

  /**
   * get cart by id.
   */
  public static final String CART_WITH_ID = CARTS_ROOT + "/" + ID_PATTERN;

  /**
   * get one cart's shipping address.
   */
  public static final String CART_SHIPPING_ADDRESS = CART_WITH_ID + "/shipping-address";
}
