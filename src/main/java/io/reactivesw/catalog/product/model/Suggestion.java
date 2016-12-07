package io.reactivesw.catalog.product.model;

/**
 * Created by Davis on 16/11/17.
 */
public class Suggestion {
  /**
   * The suggested text.
   */
  private String text;

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
   * toString method.
   * @return String
   */
  @Override
  public String toString() {
    return "Suggestion{" +
        "text='" + text + '\'' +
        '}';
  }
}
