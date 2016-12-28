package io.reactivesw.common.util;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.List;
import java.util.Set;

/**
 * Created by Davis on 16/12/28.
 */
public final class ListUtils {

  /**
   * Instantiates a new List util.
   */
  private ListUtils() {}

  /**
   * Remove duplicate string from list.
   * only use for order is not important.
   *
   * @param stringList the string list
   * @return the list
   */
  public static List<String> removeDuplicateString(List<String> stringList) {
    List<String> result = null;
    if (stringList != null) {
      Set<String> tempSet = Sets.newHashSet(stringList);
      result = Lists.newArrayList(tempSet);
    }
    return result;
  }
}
