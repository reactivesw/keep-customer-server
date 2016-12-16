package io.reactivesw.common.model.action;

import io.reactivesw.common.model.UpdateAction;
import lombok.Data;
import lombok.ToString;

/**
 * Created by Davis on 16/12/8.
 */
@Data
public class SetDescription implements UpdateAction {
  /**
   * The Description.
   */
  protected String description;

  protected String name;
  
}
