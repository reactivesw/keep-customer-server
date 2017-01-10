package io.reactivesw.order.order.domain.entity.value;

import io.reactivesw.common.entity.BaseIdEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by umasuo on 16/11/17.
 */
@Entity
@Table(name = "order_item_state")
@Data
@EqualsAndHashCode(callSuper = false)
public class ItemStateValue extends BaseIdEntity {

  /**
   * quantity that affected by the state.
   */
  @Column
  private Integer quantity;

  /**
   * an state Id.
   */
  @Column
  private String state;

}
