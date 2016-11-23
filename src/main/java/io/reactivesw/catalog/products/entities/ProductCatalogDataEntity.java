package io.reactivesw.catalog.products.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import io.reactivesw.common.entities.BaseIdEntity;

/**
 * Created by umasuo on 16/11/23.
 */
@Entity
@Table(name = "sw_product_catalog_data")
public class ProductCatalogDataEntity extends BaseIdEntity {

  /**
   * is the product been published.
   */
  @Column
  private Boolean published;

  /**
   * has staged changed.
   */
  @Column(name = "staged_changed")
  private Boolean stagedChanged;

  @OneToOne
  private ProductDataEntity current;

  @OneToOne
  private ProductDataEntity staged;


  public Boolean getPublished() {
    return published;
  }

  public void setPublished(Boolean published) {
    this.published = published;
  }

  public Boolean getStagedChanged() {
    return stagedChanged;
  }

  public void setStagedChanged(Boolean stagedChanged) {
    this.stagedChanged = stagedChanged;
  }

  public ProductDataEntity getCurrent() {
    return current;
  }

  public void setCurrent(ProductDataEntity current) {
    this.current = current;
  }

  public ProductDataEntity getStaged() {
    return staged;
  }

  public void setStaged(ProductDataEntity staged) {
    this.staged = staged;
  }
}
