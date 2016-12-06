package io.reactivesw.catalog.categories.applications.models.actions;

import io.reactivesw.common.models.UpdateAction;

/**
 * Created by Davis on 16/12/6.
 */
public class SetExternalID implements UpdateAction {
  /**
   * The External id.
   */
  private String externalId;

  /**
   * Gets external id.
   *
   * @return the external id
   */
  public String getExternalId() {
    return externalId;
  }

  /**
   * Sets external id.
   *
   * @param externalId the external id
   */
  public void setExternalId(String externalId) {
    this.externalId = externalId;
  }
}
