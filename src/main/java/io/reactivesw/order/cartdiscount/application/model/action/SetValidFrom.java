package io.reactivesw.order.cartdiscount.application.model.action;

import lombok.Data;

import java.time.ZonedDateTime;

/**
 * Created by umasuo on 16/12/22.
 */
@Data
public class SetValidFrom implements CartDiscountUpdateAction {

  private ZonedDateTime validFrom;
}
