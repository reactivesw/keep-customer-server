package io.reactivesw.catalog.producttype.application.model.action;

import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.common.model.LocalizedString;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Davis on 16/12/12.
 */
@Getter
@Setter
public class SetAttributeLabel implements UpdateAction {
  /**
   * The Attribute name.
   */
  private String attributeName;

  /**
   * The Label.
   */
  private LocalizedString label;
}
