package io.reactivesw.catalog.taxcategory.domain.service;

import io.reactivesw.catalog.taxcategory.application.model.TaxCategory;
import io.reactivesw.catalog.taxcategory.application.model.TaxCategoryDraft;
import io.reactivesw.catalog.taxcategory.application.model.mapper.TaxCategoryMapper;
import io.reactivesw.catalog.taxcategory.domain.entity.TaxCategoryEntity;
import io.reactivesw.catalog.taxcategory.domain.service.update.TaxCategoryUpdateService;
import io.reactivesw.catalog.taxcategory.infrastructure.repository.TaxCategoryRepository;
import io.reactivesw.common.exception.ConflictException;
import io.reactivesw.common.exception.NotExistException;
import io.reactivesw.common.exception.ParametersException;
import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.common.model.PagedQueryResult;
import io.reactivesw.common.model.QueryConditions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by Davis on 16/12/10.
 */
@Service
public class TaxCategoryService {
  /**
   * log.
   */
  private static final Logger LOG = LoggerFactory.getLogger(TaxCategoryService.class);

  /**
   * TaxCategoryRepository.
   */
  @Autowired
  private transient TaxCategoryRepository taxCategoryRepository;

  /**
   * TaxCategoryUpdateService.
   */
  @Autowired
  private transient TaxCategoryUpdateService updateService;

  /**
   * Create TaxCategory.
   *
   * @param draft the draft
   * @return the tax category
   */
  public TaxCategory createTaxCategory(TaxCategoryDraft draft) {
    LOG.debug("enter createTaxCategory, TaxCategoryDraft is : {}", draft.toString());

    TaxCategoryEntity entity = TaxCategoryMapper.modelToEntity(draft);

    TaxCategoryEntity savedEntity = taxCategoryRepository.save(entity);

    TaxCategory result = TaxCategoryMapper.entityToModel(savedEntity);

    // TODO: 16/12/11 send creation message

    LOG.debug("end createTaxCategory, new TaxCategory is : {}", result.toString());

    return result;
  }


  /**
   * Delete TaxCategory.
   *
   * @param id      the id
   * @param version the version
   */
  public void deleteTaxCategory(String id, Integer version) {
    LOG.debug("enter deleteTaxCategory, id is : {}, version is : {}", id, version);
    TaxCategoryEntity entity = getEntityById(id);
    validateVersion(entity, version);

    // TODO: 16/12/11 can not delete if has association of product

    taxCategoryRepository.delete(id);
    // TODO: 16/12/11 send deletion message
    LOG.debug("end deleteTaxCategory, id is : {}, version is : {}", id, version);
  }

  /**
   * Update TaxCategory.
   *
   * @param id      the id
   * @param version the version
   * @param actions the actions
   * @return the TaxCategory
   */
  public TaxCategory updateTaxCategory(String id, Integer version, List<UpdateAction> actions) {
    LOG.debug("enter updateTaxCategory, id is : {}, version is ; {}, actions is : {}",
        id, version, actions);

    TaxCategoryEntity entity = getEntityById(id);
    validateVersion(entity, version);

    actions.parallelStream().forEach(action -> updateService.handle(entity, action));

    TaxCategoryEntity updatedEntity = taxCategoryRepository.save(entity);

    TaxCategory result = TaxCategoryMapper.entityToModel(updatedEntity);

    LOG.debug("end updateTaxCategory, updated TaxCategory is : {}", result.toString());

    return result;
  }

  /**
   * Gets TaxCategory by id.
   *
   * @param id the id
   * @return the TaxCategory
   */
  public TaxCategory getTaxCategoryById(String id) {
    LOG.debug("enter getTaxCategoryById, id is : {}", id);

    TaxCategoryEntity entity = getEntityById(id);

    TaxCategory result = TaxCategoryMapper.entityToModel(entity);

    LOG.debug("end getTaxCategoryById, TaxCategory is : {}", result.toString());

    return result;
  }

  /**
   * Query tax categories paged query result.
   *
   * @param queryConditions the query conditions
   * @return the paged query result
   */
  // TODO: 16/12/13 queryconditions
  public PagedQueryResult<TaxCategory> queryTaxCategories(QueryConditions queryConditions) {
    LOG.debug("enter queryTaxCategories, QueryConditions is : {}", queryConditions.toString());
    PagedQueryResult result = new PagedQueryResult<TaxCategory>();

    List<TaxCategoryEntity> allTaxCategoryEntities = taxCategoryRepository.findAll();

    List<TaxCategory> allTaxCategories = TaxCategoryMapper.entityToModel(allTaxCategoryEntities);
    result.setResults(allTaxCategories);
    result.setTotal(allTaxCategories.size());

    LOG.debug("end queryTaxCategories, get result : {}", allTaxCategories);

    return result;
  }

  /**
   * Gets TaxCategory by id.
   *
   * @param id the id
   * @return the TaxCategory
   */
  private TaxCategoryEntity getEntityById(String id) {
    TaxCategoryEntity entity = taxCategoryRepository.findOne(id);

    if (entity == null) {
      LOG.debug("fail getEntityById, can not find TaxCategory by id:{}", id);
      throw new NotExistException("can not find TaxCategory by id : " + id);
    }
    return entity;
  }

  /**
   * judge entity and version.
   *
   * @param entity  the TaxCategoryEntity
   * @param version the version
   * @throws ParametersException when version not match
   */
  private void validateVersion(TaxCategoryEntity entity, Integer version) {

    if (!Objects.equals(version, entity.getVersion())) {
      LOG.debug("Version not match, input version:{}, entity version:{}",
          version, entity.getVersion());
      throw new ConflictException("Version not match");
    }

  }
}
