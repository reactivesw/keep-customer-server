package io.reactivesw.catalog.review.entity;

import io.reactivesw.common.entity.BaseIdEntity;
import io.reactivesw.common.util.MapJsonConverter;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Davis on 16/11/23.
 */
@Entity
@Table(name = "catalog_review_review_rating_statistics")
public class ReviewRatingStatisticsEntity extends BaseIdEntity {
  /**
   * The Average rating.
   */
  @Column(name = "average_rating")
  private Float averageRating;

  /**
   * The Highest rating.
   */
  @Column(name = "highest_rating")
  private Integer highestRating;

  /**
   * The Lowest rating.
   */
  @Column(name = "lowest_Rating")
  private Integer lowestRating;

  /**
   * The Count.
   */
  @Column
  private Integer count;

  /**
   * The Ratings distribution.
   */
  @Column(name = "ratings_distribution", columnDefinition = "JSON")
  @Convert(converter = MapJsonConverter.class)
  private Map<String, Integer> ratingsDistribution;

  /**
   * Gets average rating.
   *
   * @return the average rating
   */
  public Float getAverageRating() {
    return averageRating;
  }

  /**
   * Sets average rating.
   *
   * @param averageRating the average rating
   */
  public void setAverageRating(Float averageRating) {
    this.averageRating = averageRating;
  }

  /**
   * Gets highest rating.
   *
   * @return the highest rating
   */
  public Integer getHighestRating() {
    return highestRating;
  }

  /**
   * Sets highest rating.
   *
   * @param highestRating the highest rating
   */
  public void setHighestRating(Integer highestRating) {
    this.highestRating = highestRating;
  }

  /**
   * Gets lowest rating.
   *
   * @return the lowest rating
   */
  public Integer getLowestRating() {
    return lowestRating;
  }

  /**
   * Sets lowest rating.
   *
   * @param lowestRating the lowest rating
   */
  public void setLowestRating(Integer lowestRating) {
    this.lowestRating = lowestRating;
  }

  /**
   * Gets count.
   *
   * @return the count
   */
  public Integer getCount() {
    return count;
  }

  /**
   * Sets count.
   *
   * @param count the count
   */
  public void setCount(Integer count) {
    this.count = count;
  }

  /**
   * Gets ratings distribution.
   *
   * @return the ratings distribution
   */
  public Map<String, Integer> getRatingsDistribution() {
    return ratingsDistribution;
  }

  /**
   * Sets ratings distribution.
   *
   * @param ratingsDistribution the ratings distribution
   */
  public void setRatingsDistribution(Map<String, Integer> ratingsDistribution) {
    this.ratingsDistribution = ratingsDistribution;
  }

  /**
   * toString method.
   * @return String
   */
  @Override
  public String toString() {
    return "ReviewRatingStatisticsEntity{"
        + "averageRating=" + averageRating
        + ", highestRating=" + highestRating
        + ", lowestRating=" + lowestRating
        + ", count=" + count
        + ", ratingsDistribution=" + ratingsDistribution
        + '}';
  }
}
