package io.reactivesw.route;

/**
 * Created by umasuo on 16/12/20.
 */
public class CustomerRouter extends BaseRouter {

  /**
   * The ROOTER.
   */
  public static final String CUSTOMER_ROOT = URL_ROOT + "/customers";

  /**
   * customer id.
   */
  public static final String CUSTOMER_ID = "customerId";

  /**
   * customer root with id.
   */
  public static final String CUSTOMER_ROOT_WITH_ID = CUSTOMER_ROOT + "/{" + CUSTOMER_ID + "}";

  /**
   * customer address.
   */
  public static final String ADDRESS_ROOT = CUSTOMER_ROOT + "/addresses";

  /**
   * address id.
   */
  public static final String ADDRESS_ID = "addressId";

  /**
   * address with id.
   */
  public static final String ADDRESS_WITH_ID = ADDRESS_ROOT + "/{" + ADDRESS_ID + "}";

}
