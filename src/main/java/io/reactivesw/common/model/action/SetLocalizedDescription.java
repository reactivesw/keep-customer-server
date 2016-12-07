package io.reactivesw.common.model.action;

import io.reactivesw.common.model.LocalizedString;
import io.reactivesw.common.model.UpdateAction;

/**
 * Created by Bruce on 16/12/7.
 */
public class SetLocalizedDescription implements UpdateAction {
  /**
   * If the description parameter is not included, the field will be emptied.
   */
  private LocalizedString description;

  /**
   * Gets description.
   *
   * @return the description
   */
  public LocalizedString getDescription() {
    return description;
  }

  /**
   * Sets description.
   *
   * @param description the description
   */
  public void setDescription(LocalizedString description) {
    this.description = description;
  }
}
