package io.reactivesw.catalog.category.application.model.action;

import io.reactivesw.catalog.category.infrastructure.util.UpdateActionUtils;
import io.reactivesw.common.model.UpdateAction;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Davis on 16/12/6.
 */
@Getter
@Setter
public class SetExternalID implements UpdateAction {
  /**
   * The External id.
   */
  private String externalId;

  @Override
  public String getActionName() {
    return UpdateActionUtils.SET_EXTERNAL_ID;
  }
}
