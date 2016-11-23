package io.reactivesw.catalog.reviews.enums;

/**
 * Created by Davis on 16/11/23.
 */
public enum ReviewScore {
  ZONE(0),
  ONE(1),
  TWO(2),
  THREE(3),
  FOUR(4),
  FIVE(5);

  private int score;

  private ReviewScore(int score) {
    this.score = score;
  }
}
