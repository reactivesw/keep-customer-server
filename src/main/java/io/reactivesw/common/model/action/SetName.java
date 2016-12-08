package io.reactivesw.common.model.action;

import io.reactivesw.common.model.UpdateAction;

/**
 * Created by umasuo on 16/12/8.
 */
public class SetName implements UpdateAction {

  /**
   * name.
   */
  private String name;

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
}
