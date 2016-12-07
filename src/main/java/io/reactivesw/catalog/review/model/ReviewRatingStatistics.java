package io.reactivesw.catalog.review.model;

/**
 * Created by Davis on 16/11/17.
 */
public class ReviewRatingStatistics {

  /**
   * Average rating of one target.
   * This number is rounded with 5 decimals.
   */
  private Float averageRating;

  /**
   * Highest rating of one target.
   */
  private Float highestRating;

  /**
   * Lowest rating of one target.
   */
  private Float lowestRating;

  /**
   * Number of ratings taken into account.
   */
  private Integer count;

  /**
   * The full distribution of the ratings.
   * The keys are the different ratings and the value are the count of review having this rating.
   * Only the used ratings appear in this object.
   */
  //TODO String should be JSON object
  private String ratingsDistribution;

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
  public Float getHighestRating() {
    return highestRating;
  }

  /**
   * Sets highest rating.
   *
   * @param highestRating the highest rating
   */
  public void setHighestRating(Float highestRating) {
    this.highestRating = highestRating;
  }

  /**
   * Gets lowest rating.
   *
   * @return the lowest rating
   */
  public Float getLowestRating() {
    return lowestRating;
  }

  /**
   * Sets lowest rating.
   *
   * @param lowestRating the lowest rating
   */
  public void setLowestRating(Float lowestRating) {
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
  public String getRatingsDistribution() {
    return ratingsDistribution;
  }

  /**
   * Sets ratings distribution.
   *
   * @param ratingsDistribution the ratings distribution
   */
  public void setRatingsDistribution(String ratingsDistribution) {
    this.ratingsDistribution = ratingsDistribution;
  }

  /**
   * toString method.
   * @return String
   */
  @Override
  public String toString() {
    return "ReviewRatingStatistics{" +
        "averageRating=" + averageRating +
        ", highestRating=" + highestRating +
        ", lowestRating=" + lowestRating +
        ", count=" + count +
        ", ratingsDistribution='" + ratingsDistribution + '\'' +
        '}';
  }
}
