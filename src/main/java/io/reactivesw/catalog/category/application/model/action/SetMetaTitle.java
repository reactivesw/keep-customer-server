package io.reactivesw.catalog.category.application.model.action;

import io.reactivesw.common.model.LocalizedString;
import io.reactivesw.common.model.UpdateAction;

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
