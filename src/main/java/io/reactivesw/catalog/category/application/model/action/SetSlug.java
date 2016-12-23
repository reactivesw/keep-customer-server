package io.reactivesw.catalog.category.application.model.action;

import io.reactivesw.common.model.UpdateAction;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Created by Davis on 16/12/6.
 */
@Getter
@Setter
public class SetSlug implements UpdateAction {

  /**
   * The Slug.
   */
  @NotNull
  @Pattern(regexp = "[-a-zA-Z0-9_]{2,256}", message = "category slug can not match")
  private String slug;
}
