package io.reactivesw.order.cart.application.model.action;

import lombok.Data;

/**
 * Created by umasuo on 16/12/15.
 */
@Data
public class SetCustomLineItemCustomField {

  String customLineItemId;

  String name;

  //TODO value
}
