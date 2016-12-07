package io.reactivesw.catalog.category.application.model.action;

import io.reactivesw.common.model.Reference;
import io.reactivesw.common.model.UpdateAction;

/**
 * Created by Davis on 16/12/6.
 */
public class SetParent implements UpdateAction {
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
