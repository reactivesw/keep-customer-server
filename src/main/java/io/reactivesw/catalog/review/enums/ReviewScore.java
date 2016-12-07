package io.reactivesw.catalog.review.enums;

/**
 * Created by Davis on 16/11/23.
 */
public enum ReviewScore {
  /**
   * Zone review score.
   */
  ZONE(0),
  /**
   * One review score.
   */
  ONE(1),
  /**
   * Two review score.
   */
  TWO(2),
  /**
   * Three review score.
   */
  THREE(3),
  /**
   * Four review score.
   */
  FOUR(4),
  /**
   * Five review score.
   */
  FIVE(5);

  private int score;

  /**
   * private constructor.
   * @param score score
   */
  private ReviewScore(int score) {
    this.score = score;
  }

  /**
   * Gets score.
   *
   * @return the score
   */
  public int getScore() {
    return this.score;
  }
}
