package io.reactivesw.route;

/**
 * Created by umasuo on 16/12/21.
 */
public class ShippingMethodRouter extends BaseRouter {

  /**
   * id.
   */
  public static final String SHIPPING_METHOD_ID = "id";

  /**
   * base url for shipping method.
   */
  public static final String SHIPPING_METHOD_BASE_URL = URL_ROOT + "/shipping-methods";

  /**
   * shiping method url with id.
   */
  public static final String SHIPPING_METHOD_WITH_ID = SHIPPING_METHOD_BASE_URL + "/{" +
      SHIPPING_METHOD_ID + "}";

}
