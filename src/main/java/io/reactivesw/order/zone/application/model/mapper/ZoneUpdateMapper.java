package io.reactivesw.order.zone.application.model.mapper;

import com.google.common.collect.ImmutableMap;
import io.reactivesw.common.model.action.SetDescription;
import io.reactivesw.common.model.action.SetName;
import io.reactivesw.common.model.Update;
import io.reactivesw.order.zone.application.model.action.AddLocation;
import io.reactivesw.order.zone.application.model.action.RemoveLocation;
import io.reactivesw.order.zone.domain.entity.ZoneEntity;

import java.util.Map;

/**
 * Created by umasuo on 16/12/8.
 */
public interface ZoneUpdateMapper extends Update<ZoneEntity> {
  /**
   * ImmutableMap for discount code update mapper.
   */
  Map<Class<?>, ZoneUpdateMapper> updateMappers = ImmutableMap.of(
      SetName.class, new SetNameMapper(),
      SetDescription.class, new SetDescriptionMapper(),
      AddLocation.class, new AddLocationMapper(),
      RemoveLocation.class, new RemoveLocationMapper()
  );

  /**
   * get mapper.
   *
   * @param clazz UpdateAction class
   * @return ZoneUpdateMapper
   */
  static ZoneUpdateMapper getMapper(Class<?> clazz) {
    return updateMappers.get(clazz);
  }
}
