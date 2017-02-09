package io.reactivesw.route;


/**
 * The type Order router.
 */
public final class OrderRouter extends BaseRouter {
  /**
   * root url of order.
   */
  public static final String ORDER_ROOT = URL_ROOT + "/orders";

  /**
   * order id.
   */
  public static final String ORDER_ID = "orderId";

  /**
   * id pattern.
   */
  public static final String ID_PATTERN = "{" + ORDER_ID + "}";

  /**
   * get order by id.
   */
  public static final String ORDER_WITH_ID = ORDER_ROOT + "/" + ID_PATTERN;
}
