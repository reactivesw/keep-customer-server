package io.reactivesw.catalog.categories.applications.models.actions;

import io.reactivesw.common.models.LocalizedString;
import io.reactivesw.common.models.UpdateAction;

/**
 * Created by Davis on 16/12/6.
 */
public class SetDescription implements UpdateAction {

  /**
   * The Description.
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
