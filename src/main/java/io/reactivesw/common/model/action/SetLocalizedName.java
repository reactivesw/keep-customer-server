package io.reactivesw.common.model.action;

import io.reactivesw.common.model.LocalizedString;
import io.reactivesw.common.model.UpdateAction;

/**
 * Created by Davis on 16/12/6.
 */
public class SetLocalizedName implements UpdateAction {
  /**
   * name.
   */
  private LocalizedString name;

  /**
   * Gets name.
   *
   * @return the name
   */
  public LocalizedString getName() {
    return name;
  }

  /**
   * Sets name.
   *
   * @param name the name
   */
  public void setName(LocalizedString name) {
    this.name = name;
  }
}
