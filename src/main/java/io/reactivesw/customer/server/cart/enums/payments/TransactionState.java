package io.reactivesw.customer.server.cart.enums.payments;

/**
 * Transactions can be in one of the following states:
 * Created by umasuo on 16/11/17.
 */
public enum TransactionState {

  /**
   * The initial state.
   */
  Pending,

  /**
   * Transactions should only be set to state Success after a confirmation from the PSP was received
   * that confirms that a transaction was completed successfully. E.g. in the case of a refund, the
   * transaction is not added when the refund request is being sent to the PSP or the PSP
   * acknowledges the request (the interfaceInteractions may be used for these), but when the PSP
   * sends a notification that the refund has been executed.
   */
  Success,

  /**
   * The transaction has unrecoverably failed.
   */
  Failure;

}
