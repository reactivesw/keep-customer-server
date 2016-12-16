package io.reactivesw.order.cart.application.model.action;

import com.fasterxml.jackson.databind.JsonNode;
import io.reactivesw.common.model.ResourceIdentifier;
import lombok.Data;

/**
 * This action sets, overwrites or removes any existing custom type and fields for an existing cart.
 * Created by umasuo on 16/12/15.
 */
@Data
public class SetCustomType {

  /**
   * If set, the custom type is set to this new value.
   * If absent, the custom type and any existing custom fields are removed.
   */
  private ResourceIdentifier type;

  /**
   * A valid JSON object, based on the FieldDefinitions of the Type.
   * If set, the custom fields are set to this new value.
   */
  private JsonNode fields;
}
