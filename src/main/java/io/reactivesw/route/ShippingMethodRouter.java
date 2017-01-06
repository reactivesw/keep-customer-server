package io.reactivesw.route;

/**
 * Created by umasuo on 16/12/21.
 */
public final class ShippingMethodRouter extends BaseRouter {

  /**
   * id.
   */
  public static final String SHIPPING_METHOD_ID = "id";

  /**
   * base url for shipping method.
   */
  public static final String SHIPPING_METHOD_ROOT = URL_ROOT + "/shipping-methods";

  /**
   * shiping method url with id.
   */
  public static final String SHIPPING_METHOD_WITH_ID = SHIPPING_METHOD_ROOT + "/{" +
      SHIPPING_METHOD_ID + "}";

  /**
   * private default constructor.
   */
  private ShippingMethodRouter() {
    super();
  }

  /**
   * path builder: get shipping method with id.
   *
   * @param id String
   * @return String
   */
  public static String getShippingMethodWithId(String id) {
    return SHIPPING_METHOD_ROOT + "/" + id;
  }
}
