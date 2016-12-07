package io.reactivesw.catalog.product.entity;

import io.reactivesw.common.entity.BaseIdEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Created by umasuo on 16/11/23.
 */
@Entity
@Table(name = "catalog_product_product_catalog_data")
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

  /**
   * current data.
   */
  @OneToOne
  private ProductDataEntity current;

  /**
   * staged data.
   */
  @OneToOne
  private ProductDataEntity staged;


  /**
   * Gets published.
   *
   * @return the published
   */
  public Boolean getPublished() {
    return published;
  }

  /**
   * Sets published.
   *
   * @param published the published
   */
  public void setPublished(Boolean published) {
    this.published = published;
  }

  /**
   * Gets staged changed.
   *
   * @return the staged changed
   */
  public Boolean getStagedChanged() {
    return stagedChanged;
  }

  /**
   * Sets staged changed.
   *
   * @param stagedChanged the staged changed
   */
  public void setStagedChanged(Boolean stagedChanged) {
    this.stagedChanged = stagedChanged;
  }

  /**
   * Gets current.
   *
   * @return the current
   */
  public ProductDataEntity getCurrent() {
    return current;
  }

  /**
   * Sets current.
   *
   * @param current the current
   */
  public void setCurrent(ProductDataEntity current) {
    this.current = current;
  }

  /**
   * Gets staged.
   *
   * @return the staged
   */
  public ProductDataEntity getStaged() {
    return staged;
  }

  /**
   * Sets staged.
   *
   * @param staged the staged
   */
  public void setStaged(ProductDataEntity staged) {
    this.staged = staged;
  }

  /**
   * toString method.
   * @return String
   */
  @Override
  public String toString() {
    return "ProductCatalogDataEntity{"
        + "id=" + id
        + "published=" + published
        + ", stagedChanged=" + stagedChanged
        + ", current=" + current
        + ", staged=" + staged
        + '}';
  }
}
