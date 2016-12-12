package io.reactivesw.catalog.category.application.model.mapper;

import io.reactivesw.catalog.category.application.model.action.SetExternalID;
import io.reactivesw.catalog.category.application.model.action.SetMetaDescription;
import io.reactivesw.catalog.category.application.model.action.SetMetaKeywords;
import io.reactivesw.catalog.category.application.model.action.SetMetaTitle;
import io.reactivesw.catalog.category.application.model.action.SetOrderHint;
import io.reactivesw.catalog.category.application.model.action.SetParent;
import io.reactivesw.catalog.category.application.model.action.SetSlug;
import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.common.model.action.SetLocalizedDescription;
import io.reactivesw.common.model.action.SetLocalizedName;
import io.reactivesw.common.model.mapper.UpdateMapper;

import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Davis on 16/12/7.
 */
public interface CategoryUpdateMapper<E> extends UpdateMapper<E> {
  /**
   * ImmutableMap for discount code update mapper.
   */
  // TODO: SetCustomType and SetCustomField
  Map<Class<?>, CategoryUpdateMapper> updateMappers = ImmutableMap.<Class<?>,
      CategoryUpdateMapper>builder()
      .put(SetLocalizedName.class, new NameMapper())
      .put(SetSlug.class, new SlugMapper())
      .put(SetLocalizedDescription.class, new DescriptionMapper())
      .put(SetParent.class, new ParentMapper())
      .put(SetOrderHint.class, new OrderHintMapper())
      .put(SetExternalID.class, new ExternalIDMapper())
      .put(SetMetaTitle.class, new MetaTitleMapper())
      .put(SetMetaDescription.class, new MetaDescriptionMapper())
      .put(SetMetaKeywords.class, new MetaKeywordsMapper()).build();

  /**
   * @param clazz
   * @return
   */
  static CategoryUpdateMapper getMapper(Class<?> clazz) {
    return updateMappers.get(clazz);
  }
}