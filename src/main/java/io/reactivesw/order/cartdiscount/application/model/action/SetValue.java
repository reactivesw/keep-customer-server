package io.reactivesw.order.cartdiscount.application.model.action;

import io.reactivesw.common.model.UpdateAction;
import lombok.Data;

/**
 * Created by umasuo on 16/12/21.
 */
@Data
public class SetValue implements UpdateAction {

  private transient Integer value;

}
