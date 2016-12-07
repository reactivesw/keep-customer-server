package io.reactivesw.catalog.product.model;

/**
 * Created by Davis on 16/11/17.
 */
public class ProductCatalogData {
  /**
   * Whether the product is published.
   */
  private Boolean published;

  /**
   * The current data of the product.
   */
  private ProductData current;

  /**
   * The staged data of the product.
   */
  private ProductData staged;

  /**
   * Whether the staged data is different from the current data.
   */
  private Boolean hasStagedChanges;

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
   * Gets current.
   *
   * @return the current
   */
  public ProductData getCurrent() {
    return current;
  }

  /**
   * Sets current.
   *
   * @param current the current
   */
  public void setCurrent(ProductData current) {
    this.current = current;
  }

  /**
   * Gets staged.
   *
   * @return the staged
   */
  public ProductData getStaged() {
    return staged;
  }

  /**
   * Sets staged.
   *
   * @param staged the staged
   */
  public void setStaged(ProductData staged) {
    this.staged = staged;
  }

  /**
   * Gets has staged changes.
   *
   * @return the has staged changes
   */
  public Boolean getHasStagedChanges() {
    return hasStagedChanges;
  }

  /**
   * Sets has staged changes.
   *
   * @param hasStagedChanges the has staged changes
   */
  public void setHasStagedChanges(Boolean hasStagedChanges) {
    this.hasStagedChanges = hasStagedChanges;
  }

  /**
   * toString method.
   *
   * @return String
   */
  @Override
  public String toString() {
    return "ProductCatalogData{" +
            "published=" + published +
            ", current=" + current +
            ", staged=" + staged +
            ", hasStagedChanges=" + hasStagedChanges +
            '}';
  }
}
