package io.reactivesw.common.models;

import java.util.List;

import io.reactivesw.common.models.UpdateAction;

/**
 * Created by Davis on 16/11/21.
 */
public class Field {
  /**
   * The expected version of the category on which the changes should be applied.
   * If the expected version does not match the actual version, a 409 Conflict will be returned.
   */
  Integer version;

  /**
   * Array of UpdateAction.
   * The list of update updateactions to be performed on the category.
   * Required.
   */
  List<UpdateAction> actions;

  /**
   * Gets version.
   *
   * @return the version
   */
  public Integer getVersion() {
    return version;
  }

  /**
   * Sets version.
   *
   * @param version the version
   */
  public void setVersion(Integer version) {
    this.version = version;
  }

  /**
   * Gets updateactions.
   *
   * @return the updateactions
   */
  public List<UpdateAction> getActions() {
    return actions;
  }

  /**
   * Sets updateactions.
   *
   * @param actions the updateactions
   */
  public void setActions(List<UpdateAction> actions) {
    this.actions = actions;
  }

  @Override
  public String toString() {
    return "Field{" +
        "version=" + version +
        ", updateactions=" + actions +
        '}';
  }
}
