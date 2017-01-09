package io.reactivesw.project.domain.service.update;

import io.reactivesw.common.model.Update;
import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.project.domain.entity.InternationalEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * Created by Davis on 17/1/9.
 */
@Service
public class InternationalUpdateService implements Update<InternationalEntity> {
  /**
   * application context.
   */
  @Autowired
  private transient ApplicationContext context;

  /**
   * update handle.
   * @param entity E
   * @param action UpdateAction
   */
  @Override
  public void handle(InternationalEntity entity, UpdateAction action) {
    handle(entity, action, context);
  }
}
