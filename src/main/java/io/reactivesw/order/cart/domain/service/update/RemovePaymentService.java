package io.reactivesw.order.cart.domain.service.update;

import io.reactivesw.common.exception.NotExistException;
import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.order.cart.application.model.action.RemovePayment;
import io.reactivesw.order.cart.domain.entity.CartEntity;

import java.util.List;

/**
 * Created by umasuo on 16/12/19.
 */
public class RemovePaymentService extends CartUpdateService {


  /**
   * remove existing payment.
   *
   * @param cart   CartEntity
   * @param action UpdateAction
   */
  @Override
  public void handle(CartEntity cart, UpdateAction action) {
    RemovePayment removePayment = (RemovePayment) action;
    String payment = removePayment.getPayment();
    List<String> payments = cart.getPaymentInfo();

    //TODO  check if this payment has been assigned to other cart or order.
    if (payments == null || !payments.contains(payment)) {
      throw new NotExistException("Payment not exist in the cart");
    }
    payments.remove(payment);

    cart.setPaymentInfo(payments);
  }
}
