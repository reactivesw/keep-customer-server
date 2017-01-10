package io.reactivesw.order.order.domain.entity.value;

import io.reactivesw.common.entity.BaseIdEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Davis on 16/11/23.
 */
@Entity
@Table(name = "order_variant_attribute")
@Data
@EqualsAndHashCode(callSuper = false)
public class AttributeValue extends BaseIdEntity {

  /**
   * name.
   */
  @Column(name = "name")
  private String name;

  /**
   * Json Object for attribute value.
   */
  @Column(name = "value")
  private String value;

}
