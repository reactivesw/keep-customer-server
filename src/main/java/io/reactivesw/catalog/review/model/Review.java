package io.reactivesw.catalog.review.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.reactivesw.common.model.CustomFields;
import io.reactivesw.common.model.Reference;

import java.time.ZonedDateTime;

/**
 * Created by Davis on 16/11/17.
 */
public class Review {

  /**
   * The unique ID of the review.
   */
  private String id;

  /**
   * The current version of the review.
   */
  private Integer version;

  /**
   * The Created at.
   */
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
  private ZonedDateTime createdAt;

  /**
   * The Last modified at.
   */
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
  private ZonedDateTime lastModifiedAt;

  /**
   * User-specific unique identifier for the review.
   */
  private String key;

  /**
   * The Uniqueness value.
   */
  private String uniquenessValue;

  /**
   * IETF language tag.
   */
  private String locale;

  /**
   * The Author name.
   */
  private String authorName;

  /**
   * The Title.
   */
  private String title;

  /**
   * The Text.
   */
  private String text;

  /**
   * Identifies the target of the review. Can be a Product or a Channel.
   */
  private Reference target;

  /**
   * Number between -100 and 100 included.
   */
  private Float rating;

  /**
   * Reference to a State
   */
  private Reference state;

  /**
   * Indicates if this review is taken into account in the ratings statistics of the target.
   * A review is per default used in the statistics,
   * unless the review is in a state that does not have the role ReviewIncludedInStatistics.
   * If the role of a State is modified after the calculation of this field,
   * the calculation is not updated.
   */
  private Boolean includedInStatistics;

  /**
   * Reference to a Customer.
   * The customer who created the review.
   */
  private Reference customer;

  /**
   * The Custom.
   */
  private CustomFields custom;

  /**
   * Gets id.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Sets id.
   *
   * @param id the id
   */
  public void setId(String id) {
    this.id = id;
  }

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
   * Gets created at.
   *
   * @return the created at
   */
  public ZonedDateTime getCreatedAt() {
    return createdAt;
  }

  /**
   * Sets created at.
   *
   * @param createdAt the created at
   */
  public void setCreatedAt(ZonedDateTime createdAt) {
    this.createdAt = createdAt;
  }

  /**
   * Gets last modified at.
   *
   * @return the last modified at
   */
  public ZonedDateTime getLastModifiedAt() {
    return lastModifiedAt;
  }

  /**
   * Sets last modified at.
   *
   * @param lastModifiedAt the last modified at
   */
  public void setLastModifiedAt(ZonedDateTime lastModifiedAt) {
    this.lastModifiedAt = lastModifiedAt;
  }

  /**
   * Gets key.
   *
   * @return the key
   */
  public String getKey() {
    return key;
  }

  /**
   * Sets key.
   *
   * @param key the key
   */
  public void setKey(String key) {
    this.key = key;
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
  public Reference getTarget() {
    return target;
  }

  /**
   * Sets target.
   *
   * @param target the target
   */
  public void setTarget(Reference target) {
    this.target = target;
  }

  /**
   * Gets rating.
   *
   * @return the rating
   */
  public Float getRating() {
    return rating;
  }

  /**
   * Sets rating.
   *
   * @param rating the rating
   */
  public void setRating(Float rating) {
    this.rating = rating;
  }

  /**
   * Gets state.
   *
   * @return the state
   */
  public Reference getState() {
    return state;
  }

  /**
   * Sets state.
   *
   * @param state the state
   */
  public void setState(Reference state) {
    this.state = state;
  }

  /**
   * Gets included in statistics.
   *
   * @return the included in statistics
   */
  public Boolean getIncludedInStatistics() {
    return includedInStatistics;
  }

  /**
   * Sets included in statistics.
   *
   * @param includedInStatistics the included in statistics
   */
  public void setIncludedInStatistics(Boolean includedInStatistics) {
    this.includedInStatistics = includedInStatistics;
  }

  /**
   * Gets customer.
   *
   * @return the customer
   */
  public Reference getCustomer() {
    return customer;
  }

  /**
   * Sets customer.
   *
   * @param customer the customer
   */
  public void setCustomer(Reference customer) {
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
    return "Review{" +
        "id='" + id + '\'' +
        ", version=" + version +
        ", createdAt=" + createdAt +
        ", lastModifiedAt=" + lastModifiedAt +
        ", key='" + key + '\'' +
        ", uniquenessValue='" + uniquenessValue + '\'' +
        ", locale='" + locale + '\'' +
        ", authorName='" + authorName + '\'' +
        ", title='" + title + '\'' +
        ", text='" + text + '\'' +
        ", target=" + target +
        ", rating=" + rating +
        ", state=" + state +
        ", includedInStatistics=" + includedInStatistics +
        ", customer=" + customer +
        ", custom=" + custom +
        '}';
  }
}
