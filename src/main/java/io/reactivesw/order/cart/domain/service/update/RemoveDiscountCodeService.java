package io.reactivesw.order.cart.domain.service.update;

import io.reactivesw.common.exception.NotExistException;
import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.order.cart.application.model.action.RemoveDiscountCode;
import io.reactivesw.order.cart.domain.entity.CartEntity;

import java.util.List;

/**
 * Created by umasuo on 16/12/19.
 */
public class RemoveDiscountCodeService extends CartUpdateService {

  /**
   * remove discount code.
   *
   * @param cart   CartEntity
   * @param action UpdateAction
   */
  @Override
  public void handle(CartEntity cart, UpdateAction action) {
    RemoveDiscountCode removeDiscountCode = (RemoveDiscountCode) action;

    String code = removeDiscountCode.getCode();

    List<String> codes = cart.getDiscountCodes();

    if (codes == null || !codes.contains(code)) {
      throw new NotExistException("Discount code not exist.");
    }
    codes.remove(code);
    cart.setDiscountCodes(codes);
  }
}
