package io.reactivesw.common.model.action;

import io.reactivesw.common.model.UpdateAction;

/**
 * Created by umasuo on 16/12/8.
 */
public class SetDescription implements UpdateAction {

  private String description;

  /**
   * Gets description.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Sets description.
   *
   * @param description the description
   */
  public void setDescription(String description) {
    this.description = description;
  }
}
