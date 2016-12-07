package io.reactivesw.catalog.review.model;

import io.reactivesw.common.model.CustomFields;
import io.reactivesw.common.model.ResourceIdentifier;

/**
 * Created by Davis on 16/11/17.
 */
public class ReviewDraft {

  /**
   * User-specific unique identifier for the review.
   */
  private String key;

  /**
   * If set, this value must be unique among review.
   * For example, if you want to have only one review per customer and per product,
   * you can set the value to customer's id + product's id.
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
   * Identifies the target of the review. Can be a Product or a Channel
   */
  private ResourceIdentifier target;

  /**
   * ResourceIdentifier to a State.
   */
  private ResourceIdentifier state;

  /**
   * Number between -100 and 100 included.
   * Rating of the targeted object, like a product.
   * This rating can represent the number of stars, or a percentage, or a like (+1)/dislike (-1)
   * A rating is used in the ratings statistics of the targeted object,
   * unless the review is in a state that does not have the role ReviewIncludedInStatistics.
   */
  private Float rating;

  /**
   * ResourceIdentifier to a Customer.
   * The customer who created the review.
   * Optional.
   */
  private ResourceIdentifier customer;

  /**
   * The Custom.
   */
  private CustomFields custom;

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
  public ResourceIdentifier getTarget() {
    return target;
  }

  /**
   * Sets target.
   *
   * @param target the target
   */
  public void setTarget(ResourceIdentifier target) {
    this.target = target;
  }

  /**
   * Gets state.
   *
   * @return the state
   */
  public ResourceIdentifier getState() {
    return state;
  }

  /**
   * Sets state.
   *
   * @param state the state
   */
  public void setState(ResourceIdentifier state) {
    this.state = state;
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
   * Gets customer.
   *
   * @return the customer
   */
  public ResourceIdentifier getCustomer() {
    return customer;
  }

  /**
   * Sets customer.
   *
   * @param customer the customer
   */
  public void setCustomer(ResourceIdentifier customer) {
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
   *
   * @return String
   */
  @Override
  public String toString() {
    return "ReviewDraft{" +
        "key='" + key + '\'' +
        ", uniquenessValue='" + uniquenessValue + '\'' +
        ", locale='" + locale + '\'' +
        ", authorName='" + authorName + '\'' +
        ", title='" + title + '\'' +
        ", text='" + text + '\'' +
        ", target=" + target +
        ", state=" + state +
        ", rating=" + rating +
        ", customer=" + customer +
        ", custom=" + custom +
        '}';
  }
}
