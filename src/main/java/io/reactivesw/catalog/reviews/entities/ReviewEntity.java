package io.reactivesw.catalog.reviews.entities;

import io.reactivesw.common.entities.BaseAllEntity;
import io.reactivesw.common.models.CustomFields;
import io.reactivesw.common.utils.CustomFieldsJsonConverter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Table;

/**
 * Created by umasuo on 16/11/23.
 */
@Table(name = "sw_review")
public class ReviewEntity extends BaseAllEntity {

  /**
   * The Version.
   */
  @Column
  private Integer version;

  /**
   * The Key value.
   */
  @Column
  private String keyValue;

  /**
   * The Uniqueness value.
   */
  @Column
  private String uniquenessValue;

  /**
   * The Locale.
   */
  @Column
  private String locale;

  /**
   * The Author name.
   */
  @Column(name = "author_name")
  private String authorName;

  /**
   * The Title.
   */
  @Column
  private String title;

  /**
   * The Text.
   */
  @Column
  private String text;

  /**
   * The Target.
   */
  @Column
  private String target;

  /**
   * The Target type.
   */
  @Column(name = "target_type")
  private String targetType;

  /**
   * state id.
   */
  @Column
  private String state;

  /**
   * The Rating.
   */
  @Column
  private Integer rating;

  /**
   * customer Id.
   */
  @Column
  private String customer;

  /**
   * custom.
   */
  @Column
  @Convert(converter = CustomFieldsJsonConverter.class)
  private CustomFields custom;

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
   * Gets key value.
   *
   * @return the key value
   */
  public String getKeyValue() {
    return keyValue;
  }

  /**
   * Sets key value.
   *
   * @param keyValue the key value
   */
  public void setKeyValue(String keyValue) {
    this.keyValue = keyValue;
  }

  /**
   * Gets uniqueness value.
   *
   * @return the uniqueness value
   */
  public String getUniquenessValue() {
    return uniquenessValue;
  }

  /**
   * Sets uniqueness value.
   *
   * @param uniquenessValue the uniqueness value
   */
  public void setUniquenessValue(String uniquenessValue) {
    this.uniquenessValue = uniquenessValue;
  }

  /**
   * Gets locale.
   *
   * @return the locale
   */
  public String getLocale() {
    return locale;
  }

  /**
   * Sets locale.
   *
   * @param locale the locale
   */
  public void setLocale(String locale) {
    this.locale = locale;
  }

  /**
   * Gets author name.
   *
   * @return the author name
   */
  public String getAuthorName() {
    return authorName;
  }

  /**
   * Sets author name.
   *
   * @param authorName the author name
   */
  public void setAuthorName(String authorName) {
    this.authorName = authorName;
  }

  /**
   * Gets title.
   *
   * @return the title
   */
  public String getTitle() {
    return title;
  }

  /**
   * Sets title.
   *
   * @param title the title
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * Gets text.
   *
   * @return the text
   */
  public String getText() {
    return text;
  }

  /**
   * Sets text.
   *
   * @param text the text
   */
  public void setText(String text) {
    this.text = text;
  }

  /**
   * Gets target.
   *
   * @return the target
   */
  public String getTarget() {
    return target;
  }

  /**
   * Sets target.
   *
   * @param target the target
   */
  public void setTarget(String target) {
    this.target = target;
  }

  /**
   * Gets target type.
   *
   * @return the target type
   */
  public String getTargetType() {
    return targetType;
  }

  /**
   * Sets target type.
   *
   * @param targetType the target type
   */
  public void setTargetType(String targetType) {
    this.targetType = targetType;
  }

  /**
   * Gets state.
   *
   * @return the state
   */
  public String getState() {
    return state;
  }

  /**
   * Sets state.
   *
   * @param state the state
   */
  public void setState(String state) {
    this.state = state;
  }

  /**
   * Gets rating.
   *
   * @return the rating
   */
  public Integer getRating() {
    return rating;
  }

  /**
   * Sets rating.
   *
   * @param rating the rating
   */
  public void setRating(Integer rating) {
    this.rating = rating;
  }

  /**
   * Gets customer.
   *
   * @return the customer
   */
  public String getCustomer() {
    return customer;
  }

  /**
   * Sets customer.
   *
   * @param customer the customer
   */
  public void setCustomer(String customer) {
    this.customer = customer;
  }

  /**
   * Gets custom.
   *
   * @return the custom
   */
  public CustomFields getCustom() {
    return custom;
  }

  /**
   * Sets custom.
   *
   * @param custom the custom
   */
  public void setCustom(CustomFields custom) {
    this.custom = custom;
  }

  /**
   * toString method.
   * @return String
   */
  @Override
  public String toString() {
    return "ReviewEntity{"
        + "id=" + id
        + "version=" + version
        + ", keyValue='" + keyValue + '\''
        + ", uniquenessValue='" + uniquenessValue + '\''
        + ", locale='" + locale + '\''
        + ", authorName='" + authorName + '\''
        + ", title='" + title + '\''
        + ", text='" + text + '\''
        + ", target='" + target + '\''
        + ", targetType='" + targetType + '\''
        + ", state='" + state + '\''
        + ", rating=" + rating
        + ", customer='" + customer + '\''
        + ", custom=" + custom
        + '}';
  }
}
