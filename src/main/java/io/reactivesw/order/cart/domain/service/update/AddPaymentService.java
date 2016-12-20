package io.reactivesw.order.cart.domain.service.update;

import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.order.cart.application.model.action.AddPayment;
import io.reactivesw.order.cart.domain.entity.CartEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * This action adds a payment to the PaymentInfo. The payment must not be assigned to another
 * Order or active Cart yet.
 * Created by umasuo on 16/12/19.
 */
public class AddPaymentService extends CartUpdateService {

  /**
   * add payment.
   *
   * @param cart   CartEntity
   * @param action UpdateAction
   */
  @Override
  public void handle(CartEntity cart, UpdateAction action) {
    AddPayment addPayment = (AddPayment) action;
    String payment = addPayment.getPayment();
    List<String> payments = cart.getPaymentInfo();

    //TODO  check if this payment has been assigned to other cart or order.
    if (payments == null) {
      payments = new ArrayList<>();
    }

    if (!payments.contains(payment)) {
      payments.add(payment);
    }

    cart.setPaymentInfo(payments);
  }
}
