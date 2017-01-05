package io.reactivesw.route;

/**
 * Created by Davis on 17/1/5.
 */
public final class PaymentRouter {
  /**
   * The constant payment_root.
   */
  public static final String PAYMENT_ROOT = "/payments";

  /**
   * The constant payment_client_token.
   */
  public static final String PAYMENT_CLIENT_TOKEN = PAYMENT_ROOT + "/client-token";

  /**
   * The constant payment_transactionId.
   */
  public static final String PAYMENT_TRANSACTIONID = "transactionId";

  /**
   * The constant payment_with_transaction_id.
   */
  public static final String PAYMENT_WITH_TRANSACTION_ID = PAYMENT_ROOT + "/{" +
      PAYMENT_TRANSACTIONID + "}";
}
