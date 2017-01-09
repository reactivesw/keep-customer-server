package io.reactivesw.project.domain.service;

import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.project.application.model.International;
import io.reactivesw.project.application.model.mapper.InternationalMapper;
import io.reactivesw.project.domain.entity.InternationalEntity;
import io.reactivesw.project.domain.service.update.InternationalUpdateService;
import io.reactivesw.project.infrastructure.repository.InternationalRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by umasuo on 17/1/5.
 */
@Service
public class InternationalService {

  /**
   * logger.
   */
  private final static Logger LOG = LoggerFactory.getLogger(InternationalService.class);

  /**
   * repository.
   */
  @Autowired
  private transient InternationalRepository repository;

  /**
   * international update service.
   */
  @Autowired
  private transient InternationalUpdateService updateService;

  /**
   * Gets international.
   *
   * @return the international
   */
  public International getInternational() {
    LOG.debug("enter getInternational");

    International result = InternationalMapper.entityToModel(getInternationalEntity());

    LOG.debug("end getInternational, result is : {}", result.toString());

    return result;
  }

  /**
   * Update international.
   *
   * @param actions the actions
   * @return the international
   */
  public International updateInternational(List<UpdateAction> actions) {
    LOG.debug("enter updateInternational, update action is {}",
        actions);

    InternationalEntity entity = getInternationalEntity();

    actions.parallelStream().forEach(action -> {
      updateService.handle(entity, action);
    });

    InternationalEntity savedEntity = repository.save(entity);

    International result = InternationalMapper.entityToModel(savedEntity);

    LOG.debug("end setDefaultCurrency, new international is : {}", result.toString());

    return result;
  }

  /**
   * initial international.
   *
   * @return InternationalEntity
   */
  private InternationalEntity initialInternational() {
    LOG.debug("enter initialInternational");

    InternationalEntity entity = new InternationalEntity();

    InternationalEntity savedEntity = repository.save(entity);

    LOG.debug("end initialInternational");

    return savedEntity;
  }

  /**
   * get international entity.
   *
   * @return InternationalEntity
   */
  private InternationalEntity getInternationalEntity() {
    LOG.debug("enter getInternationalEntity");
    InternationalEntity result = null;

    List<InternationalEntity> internationalEntities = repository.findAll();

    if (internationalEntities == null || internationalEntities.isEmpty()) {
      LOG.debug("International Entity is null, should initial data");
      result = initialInternational();
      LOG.debug("end initial data, new international is : {}", result);
    } else {
      result = internationalEntities.parallelStream()
          .findAny().get();
    }

    return result;
  }
}
