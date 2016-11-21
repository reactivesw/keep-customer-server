package io.reactivesw.customer.server.common.models;

/**
 * Created by Davis on 16/11/17.
 */
public class SearchKeyword {
  /**
   * Text to return in the result of a suggest query.
   */
  private String text;

  /**
   * If no tokenizer is defined, the text is used as as single token.
   */
  private SuggestTokenizer suggestTokenizer;

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
   * Gets suggest tokenizer.
   *
   * @return the suggest tokenizer
   */
  public SuggestTokenizer getSuggestTokenizer() {
    return suggestTokenizer;
  }

  /**
   * Sets suggest tokenizer.
   *
   * @param suggestTokenizer the suggest tokenizer
   */
  public void setSuggestTokenizer(SuggestTokenizer suggestTokenizer) {
    this.suggestTokenizer = suggestTokenizer;
  }

  /**
   * toString method.
   * @return String
   */
  @Override
  public String toString() {
    return "SearchKeyword{" +
        "text='" + text + '\'' +
        ", suggestTokenizer=" + suggestTokenizer +
        '}';
  }
}
