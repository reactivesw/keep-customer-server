package io.reactivesw.catalog.reviews.entities;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Table;

import io.reactivesw.common.entities.BaseAllEntity;
import io.reactivesw.common.models.CustomFields;
import io.reactivesw.common.utils.CustomFieldsJsonConverter;

/**
 * Created by umasuo on 16/11/23.
 */
@Table(name = "sw_review")
public class ReviewEntity extends BaseAllEntity {

  @Column
  private Integer version;

  @Column
  private String keyValue;

  @Column
  private String uniquenessValue;

  @Column
  private String locale;

  @Column(name = "author_name")
  private String authorName;

  @Column
  private String title;

  @Column
  private String text;

  @Column
  private String target;

  @Column(name = "target_type")
  private String targetType;

  /**
   * state id.
   */
  @Column
  private String state;

  @Column
  private Integer rating;

  /**
   * customer Id.
   */
  @Column
  private String customer;

  @Column
  @Convert(converter = CustomFieldsJsonConverter.class)
  private CustomFields custom;

  public Integer getVersion() {
    return version;
  }

  public void setVersion(Integer version) {
    this.version = version;
  }

  public String getKeyValue() {
    return keyValue;
  }

  public void setKeyValue(String keyValue) {
    this.keyValue = keyValue;
  }

  public String getUniquenessValue() {
    return uniquenessValue;
  }

  public void setUniquenessValue(String uniquenessValue) {
    this.uniquenessValue = uniquenessValue;
  }

  public String getLocale() {
    return locale;
  }

  public void setLocale(String locale) {
    this.locale = locale;
  }

  public String getAuthorName() {
    return authorName;
  }

  public void setAuthorName(String authorName) {
    this.authorName = authorName;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getTarget() {
    return target;
  }

  public void setTarget(String target) {
    this.target = target;
  }

  public String getTargetType() {
    return targetType;
  }

  public void setTargetType(String targetType) {
    this.targetType = targetType;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public Integer getRating() {
    return rating;
  }

  public void setRating(Integer rating) {
    this.rating = rating;
  }

  public String getCustomer() {
    return customer;
  }

  public void setCustomer(String customer) {
    this.customer = customer;
  }

  public CustomFields getCustom() {
    return custom;
  }

  public void setCustom(CustomFields custom) {
    this.custom = custom;
  }
}
