package io.reactivesw.catalog.categories.applications.models.actions;

import com.fasterxml.jackson.databind.util.JSONPObject;
import io.reactivesw.common.models.ResourceIdentifier;
import io.reactivesw.common.models.UpdateAction;

/**
 * Created by Davis on 16/12/6.
 */
public class SetCustomType implements UpdateAction {
  /**
   * The Type.
   */
  private ResourceIdentifier type;

  /**
   * The Fields.
   */
  private JSONPObject fields;

  /**
   * Gets type.
   *
   * @return the type
   */
  public ResourceIdentifier getType() {
    return type;
  }

  /**
   * Sets type.
   *
   * @param type the type
   */
  public void setType(ResourceIdentifier type) {
    this.type = type;
  }

  /**
   * Gets fields.
   *
   * @return the fields
   */
  public JSONPObject getFields() {
    return fields;
  }

  /**
   * Sets fields.
   *
   * @param fields the fields
   */
  public void setFields(JSONPObject fields) {
    this.fields = fields;
  }
}
