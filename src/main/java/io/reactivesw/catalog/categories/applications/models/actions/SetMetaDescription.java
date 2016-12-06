package io.reactivesw.catalog.categories.applications.models.actions;

import io.reactivesw.common.models.LocalizedString;
import io.reactivesw.common.models.UpdateAction;

/**
 * Created by Davis on 16/12/6.
 */
public class SetMetaDescription implements UpdateAction {
  /**
   * The Meta description.
   */
  private LocalizedString metaDescription;

  /**
   * Gets meta description.
   *
   * @return the meta description
   */
  public LocalizedString getMetaDescription() {
    return metaDescription;
  }

  /**
   * Sets meta description.
   *
   * @param metaDescription the meta description
   */
  public void setMetaDescription(LocalizedString metaDescription) {
    this.metaDescription = metaDescription;
  }
}
