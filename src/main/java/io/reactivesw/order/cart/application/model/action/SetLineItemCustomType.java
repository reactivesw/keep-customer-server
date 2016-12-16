package io.reactivesw.order.cart.application.model.action;

import com.fasterxml.jackson.databind.JsonNode;
import io.reactivesw.common.model.ResourceIdentifier;
import lombok.Data;

/**
 * Created by umasuo on 16/12/15.
 */
@Data
public class SetLineItemCustomType {

  /**
   * If set, the custom type is set to this new value.
   * If absent, the custom type and any existing CustomFields are removed at the same time.
   */
  private ResourceIdentifier type;

  private String lineItemId;

  /**
   * A valid JSON object, based on the FieldDefinitions of the Type.
   * If set, the custom fields are set to this new value.
   */
  private JsonNode fields;
}
