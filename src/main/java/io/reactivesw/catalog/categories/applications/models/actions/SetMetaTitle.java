package io.reactivesw.catalog.categories.applications.models.actions;

import io.reactivesw.common.models.LocalizedString;
import io.reactivesw.common.models.UpdateAction;

/**
 * Created by Davis on 16/12/6.
 */
public class SetMetaTitle implements UpdateAction {
  /**
   * The Meta title.
   */
  private LocalizedString metaTitle;

  /**
   * Gets meta title.
   *
   * @return the meta title
   */
  public LocalizedString getMetaTitle() {
    return metaTitle;
  }

  /**
   * Sets meta title.
   *
   * @param metaTitle the meta title
   */
  public void setMetaTitle(LocalizedString metaTitle) {
    this.metaTitle = metaTitle;
  }
}
