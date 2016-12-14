package io.reactivesw.common.model;

import lombok.Data;
import lombok.Value;

import java.util.List;

/**
 * Created by Davis on 16/12/10.
 */
@Data
public class PagedQueryResult<T> {
  Integer offset;

  Integer count;

  Integer total;

  List<T> results;

  Object facets;
}
