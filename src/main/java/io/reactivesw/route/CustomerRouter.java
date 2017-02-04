package io.reactivesw.route;

/**
 * Created by umasuo on 16/12/20.
 */
public final class CustomerRouter extends BaseRouter {

  /**
   * The ROOTER.
   */
  public static final String CUSTOMER_ROOT = URL_ROOT + "/customers";

  /**
   * customer id.
   */
  public static final String CUSTOMER_ID = "id";

  /**
   * customer root with id.
   */
  public static final String CUSTOMER_WITH_ID = CUSTOMER_ROOT + "/{" + CUSTOMER_ID + "}";

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


  private CustomerRouter() {
    super();
  }

  /**
   * get path with customer id.
   *
   * @param customerId customer id
   * @return String
   */
  public static String getCustomerWithId(String customerId) {
    return CUSTOMER_ROOT + "/" + customerId;
  }

  /**
   * url builder: get address with id.
   *
   * @param addressId String
   * @return String
   */
  public static String getAddressWithId(String addressId) {
    return ADDRESS_ROOT + "/" + addressId;
  }

  /**
   * path builder: get customer with email.
   *
   * @param email String
   * @return String
   */
  public static String getCustomerWithEmail(String email) {
    return CUSTOMER_ROOT + "?email=" + email;
  }

  /**
   * path builder:get customer with google token
   *
   * @param gToken google token
   * @return String
   */
  public static String getCustomerWithGoogle(String gToken) {
    return CUSTOMER_ROOT + "?gToken=" + gToken;
  }

}
