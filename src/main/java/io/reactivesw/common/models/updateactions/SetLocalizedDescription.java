package io.reactivesw.common.models.updateactions;

import io.reactivesw.common.models.LocalizedString;
import io.reactivesw.common.models.UpdateAction;

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
