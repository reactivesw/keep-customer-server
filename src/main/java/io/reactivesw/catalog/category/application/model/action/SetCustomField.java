package io.reactivesw.catalog.category.application.model.action;

import com.fasterxml.jackson.databind.util.JSONPObject;
import io.reactivesw.common.model.UpdateAction;

/**
 * Created by Davis on 16/12/6.
 */
public class SetCustomField implements UpdateAction {
  /**
   * The Name.
   */
  private String name;

  /**
   * The Value.
   */
  private JSONPObject value;

  /**
   * Gets name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets name.
   *
   * @param name the name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets value.
   *
   * @return the value
   */
  public JSONPObject getValue() {
    return value;
  }

  /**
   * Sets value.
   *
   * @param value the value
   */
  public void setValue(JSONPObject value) {
    this.value = value;
  }
}
