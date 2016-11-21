package io.reactivesw.products.models;

import java.util.List;

/**
 * Created by Davis on 16/11/17.
 */
public class SuggestionResult {
  /**
   * The Search keywords.
   */
  private List<Suggestion> searchKeywords;

  /**
   * Gets search keywords.
   *
   * @return the search keywords
   */
  public List<Suggestion> getSearchKeywords() {
    return searchKeywords;
  }

  /**
   * Sets search keywords.
   *
   * @param searchKeywords the search keywords
   */
  public void setSearchKeywords(List<Suggestion> searchKeywords) {
    this.searchKeywords = searchKeywords;
  }

  /**
   * toString method.
   * @return String
   */
  @Override
  public String toString() {
    return "SuggestionResult{" +
        "searchKeywords=" + searchKeywords +
        '}';
  }
}
