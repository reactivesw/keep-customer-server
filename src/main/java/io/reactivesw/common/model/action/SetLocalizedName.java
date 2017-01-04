package io.reactivesw.common.model.action;

import io.reactivesw.common.model.LocalizedString;
import io.reactivesw.common.model.UpdateAction;
import lombok.Data;

/**
 * Created by Davis on 16/12/6.
 */
@Data
public class SetLocalizedName implements UpdateAction {
  /**
   * name.
   */
  private LocalizedString name;

  @Override
  public String getActionName() {
    return null;
  }
}
