package io.reactivesw.common.model.action;

import io.reactivesw.common.model.UpdateAction;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Davis on 16/12/8.
 */
@Getter
@Setter
public class SetDescription implements UpdateAction {
  /**
   * The Description.
   */
  private String description;
}
