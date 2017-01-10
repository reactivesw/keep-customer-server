package io.reactivesw.project.application.model.action;

import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.project.infrastructure.util.InternationalActionUtils;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Davis on 17/1/9.
 */
@Getter
@Setter
public class RemoveSupportLanguageAction implements UpdateAction {
  /**
   * The Currency code.
   */
  private String languageCode;

  @Override
  public String getActionName() {
    return InternationalActionUtils.REMOVE_SUPPORT_LANGUAGE;
  }
}
