package io.reactivesw.order.cart.application.model.action;

import lombok.Data;

/**
 * This action sets, overwrites or removes any existing custom field for an existing cart.
 * Created by umasuo on 16/12/15.
 */
@Data
public class SetCustomField {

  String name;

  //TODO value;
}
