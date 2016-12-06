package io.reactivesw.orders.discountcodes.domains.entities;

import io.reactivesw.common.entities.BaseAllEntity;
import io.reactivesw.common.entities.LocalizedStringEntity;
import io.reactivesw.common.models.Statics;
import io.reactivesw.common.utils.ListJsonConverter;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Created by umasuo on 16/12/6.
 */
@Entity
@Table(name = "orders_discount_codes_discount_code")
public class DiscountCodeEntity extends BaseAllEntity {

  /**
   * version.
   */
  @Column
  private Integer version;

  /**
   * localized string name.
   */
  @OneToMany
  private Set<LocalizedStringEntity> name;

  /**
   * description.
   */
  @OneToMany
  private Set<LocalizedStringEntity> description;

  /**
   * code.
   */
  @Column
  private String code;

  /**
   * cart discounts.
   */
  @Column(name = "cart_discounts", columnDefinition = Statics.JSON)
  @Convert(converter = ListJsonConverter.class)
  private List<String> cartDiscounts;

  /**
   * CartDiscountPredicate.
   * TODO we should implement an simple one for the first edition.
   */
  @Column(name = "cart_predicate")
  private String cartPredicate;

  /**
   * is active.
   */
  @Column
  private Boolean active;

  /**
   * references.
   */
  @Column(name = "reference", columnDefinition = Statics.JSON)
  @Convert(converter = ListJsonConverter.class)
  private List<String> references;

  /**
   * max applications.
   */
  @Column(name = "max_applications")
  private Integer maxApplications;

  /**
   * max applications per customer.
   */
  @Column(name = "max_applications_per_customer")
  private Integer maxApplicationsPerCustomer;

  /**
   * Gets version.
   *
   * @return the version
   */
  public Integer getVersion() {
    return version;
  }

  /**
   * Sets version.
   *
   * @param version the version
   */
  public void setVersion(Integer version) {
    this.version = version;
  }

  /**
   * Gets name.
   *
   * @return the name
   */
  public Set<LocalizedStringEntity> getName() {
    return name;
  }

  /**
   * Sets name.
   *
   * @param name the name
   */
  public void setName(Set<LocalizedStringEntity> name) {
    this.name = name;
  }

  /**
   * Gets description.
   *
   * @return the description
   */
  public Set<LocalizedStringEntity> getDescription() {
    return description;
  }

  /**
   * Sets description.
   *
   * @param description the description
   */
  public void setDescription(Set<LocalizedStringEntity> description) {
    this.description = description;
  }

  /**
   * Gets code.
   *
   * @return the code
   */
  public String getCode() {
    return code;
  }

  /**
   * Sets code.
   *
   * @param code the code
   */
  public void setCode(String code) {
    this.code = code;
  }

  /**
   * Gets cart discounts.
   *
   * @return the cart discounts
   */
  public List<String> getCartDiscounts() {
    return cartDiscounts;
  }

  /**
   * Sets cart discounts.
   *
   * @param cartDiscounts the cart discounts
   */
  public void setCartDiscounts(List<String> cartDiscounts) {
    this.cartDiscounts = cartDiscounts;
  }

  /**
   * Gets cart predicate.
   *
   * @return the cart predicate
   */
  public String getCartPredicate() {
    return cartPredicate;
  }

  /**
   * Sets cart predicate.
   *
   * @param cartPredicate the cart predicate
   */
  public void setCartPredicate(String cartPredicate) {
    this.cartPredicate = cartPredicate;
  }

  /**
   * Gets active.
   *
   * @return the active
   */
  public Boolean getActive() {
    return active;
  }

  /**
   * Sets active.
   *
   * @param active the active
   */
  public void setActive(Boolean active) {
    this.active = active;
  }

  /**
   * Gets references.
   *
   * @return the references
   */
  public List<String> getReferences() {
    return references;
  }

  /**
   * Sets references.
   *
   * @param references the references
   */
  public void setReferences(List<String> references) {
    this.references = references;
  }

  /**
   * Gets max applications.
   *
   * @return the max applications
   */
  public Integer getMaxApplications() {
    return maxApplications;
  }

  /**
   * Sets max applications.
   *
   * @param maxApplications the max applications
   */
  public void setMaxApplications(Integer maxApplications) {
    this.maxApplications = maxApplications;
  }

  /**
   * Gets max applications per customer.
   *
   * @return the max applications per customer
   */
  public Integer getMaxApplicationsPerCustomer() {
    return maxApplicationsPerCustomer;
  }

  /**
   * Sets max applications per customer.
   *
   * @param maxApplicationsPerCustomer the max applications per customer
   */
  public void setMaxApplicationsPerCustomer(Integer maxApplicationsPerCustomer) {
    this.maxApplicationsPerCustomer = maxApplicationsPerCustomer;
  }

  /**
   * to string method.
   *
   * @return String
   */
  @Override
  public String toString() {
    return "DiscountCodeEntity{"
        + "version=" + version
        + ", name=" + name
        + ", description=" + description
        + ", code='" + code + '\''
        + ", cartDiscounts=" + cartDiscounts
        + ", cartPredicate='" + cartPredicate + '\''
        + ", isActive=" + active
        + ", references=" + references
        + ", maxApplications=" + maxApplications
        + ", maxApplicationsPerCustomer=" + maxApplicationsPerCustomer
        + '}';
  }
}
