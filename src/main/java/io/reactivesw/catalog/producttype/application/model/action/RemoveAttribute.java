package io.reactivesw.catalog.producttype.application.model.action;

import io.reactivesw.common.model.UpdateAction;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Davis on 16/12/12.
 */
@Getter
@Setter
public class RemoveAttribute implements UpdateAction {
  /**
   * The Name.
   */
  private String name;
}
