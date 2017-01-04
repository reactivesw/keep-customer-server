package io.reactivesw.order.cart.infrastructure.util;

/**
 * Created by umasuo on 17/1/4.
 */
public final class CartUpdateActionUtils {

  /**
   * default private constructor.
   */
  private CartUpdateActionUtils() {
  }

  /**
   * add lineItem.
   */
  public static final String ADD_LINE_ITEM = "cart_add_line_item";

  /**
   * remove lineItem.
   */
  public static final String REMOVE_LINE_ITEM = "cart_remove_line_item";

  /**
   * set lineItem quantity.
   */
  public static final String SET_LINE_ITEM_QUANTITY = "cart_set_line_item_quantity";

  /**
   * set billing address.
   */
  public static final String SET_BILLING_ADDRESS = "cart_set_billing_address";

  /**
   * set shipping address.
   */
  public static final String SET_SHIPPING_ADDRESS = "cart_set_shipping_address";

  /**
   * set country.
   */
  public static final String SET_COUNTRY = "cart_set_country";

  /**
   * set customer id.
   */
  public static final String SET_CUSTOMER_ID = "cart_set_customer_id";

  /**
   * set tax mode, default is platform.
   */
  public static final String SET_TAX_MODE = "cart_set_tax_mode";

  /**
   * set tax mode, default is platform.
   */
  public static final String SET_SHIPPING_METHOD = "cart_set_shipping_method";


}
