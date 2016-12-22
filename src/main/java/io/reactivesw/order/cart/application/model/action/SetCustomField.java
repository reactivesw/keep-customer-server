package io.reactivesw.order.cart.application.model.action;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;

/**
 * This action sets, overwrites or removes any existing custom field for an existing cart.
 * Created by umasuo on 16/12/15.
 */
@Data
public class SetCustomField {

  private String name;

  private JsonNode value;
}
