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

  /**
   * customer id.
   */
  public static final String CUSTOMER_ID = "subjectId";

  /**
   * credit card.
   */
  public static final String CREDIT_CARDS = "credit-cards";

  /**
   * The constant PAYMENT_WITH_CREDIT_CARDS.
   */
  public static final String PAYMENT_WITH_CREDIT_CARDS = PAYMENT_ROOT + "/" + CREDIT_CARDS;

  /**
   * payment with credit cards and customer id, /payments/credit-cards/{subjectId}.
   */
  public static final String PAYMENT_WITH_CUSTOMER_ID = PAYMENT_WITH_CREDIT_CARDS +
      "/{" + CUSTOMER_ID + "}";
}
