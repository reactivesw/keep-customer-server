package io.reactivesw.catalog.categories.applications.models.actions;

import io.reactivesw.common.models.Reference;

/**
 * Created by Davis on 16/12/6.
 */
public class ChangeParent {
  /**
   * The Parent.
   */
  private Reference parent;

  /**
   * Gets parent.
   *
   * @return the parent
   */
  public Reference getParent() {
    return parent;
  }

  /**
   * Sets parent.
   *
   * @param parent the parent
   */
  public void setParent(Reference parent) {
    this.parent = parent;
  }
}
