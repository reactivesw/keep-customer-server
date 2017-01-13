package io.reactivesw.merchant.domain.entity;

import io.reactivesw.common.entity.BaseIdEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by umasuo on 17/1/5.
 */
@Entity
@Table(name = "project_language")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false, of = {"languageCode", "nativeName", "name"})
public class LanguageValue extends BaseIdEntity {

  /**
   * currency code.
   */
  @Column
  private String languageCode;

  /**
   * name.
   */
  @Column
  private String name;

  /**
   * conversion factor.
   */
  @Column
  private String nativeName;
}
