package io.reactivesw.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Davis on 16/11/17.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchKeyword {
  /**
   * Text to return in the result of a suggest query.
   */
  private String text;

  /**
   * If no tokenizer is defined, the text is used as as single token.
   */
  private SuggestTokenizer suggestTokenizer;
}
