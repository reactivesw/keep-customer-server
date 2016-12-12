package io.reactivesw.catalog.producttype.domain.service;

import io.reactivesw.catalog.producttype.application.model.ProductType;
import io.reactivesw.catalog.producttype.application.model.ProductTypeDraft;
import io.reactivesw.catalog.producttype.application.model.mapper.ProductTypeMapper;
import io.reactivesw.catalog.producttype.application.model.mapper.ProductTypeUpdateMapper;
import io.reactivesw.catalog.producttype.domain.entity.ProductTypeEntity;
import io.reactivesw.catalog.producttype.infrastructure.repository.ProductTypeRepository;
import io.reactivesw.common.exception.ConflictException;
import io.reactivesw.common.exception.NotExistException;
import io.reactivesw.common.model.UpdateAction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by Davis on 16/12/7.
 */
@Service
public class ProductTypeService {
  /**
   * log.
   */
  private static final Logger LOG = LoggerFactory.getLogger(ProductTypeService.class);

  /**
   * The Product type repository.
   */
  @Autowired
  private transient ProductTypeRepository productTypeRepository;

  /**
   * Create product type.
   *
   * @param productTypeDraft the product type draft
   * @return the product type
   */
  public ProductType createProductType(ProductTypeDraft productTypeDraft) {
    LOG.debug("enter createProductType, product type draft is:{}", productTypeDraft.toString());

    ProductTypeEntity entity = ProductTypeMapper.modelToEntity(productTypeDraft);

    ProductTypeEntity savedEntity = productTypeRepository.save(entity);

    ProductType result = ProductTypeMapper.entityToModel(savedEntity);

    LOG.debug("end createProductType, new product type is:{}", result.toString());
    return result;
  }

  /**
   * Delete ProductType by id.
   *
   * @param id      the id
   * @param version the version
   */
  public void deleteProductTypeById(String id, Integer version) {
    LOG.debug("enter deleteProductTypeById, id is : {}, version is : {}", id, version);

    ProductTypeEntity entity = getProductTypeEntityById(id);
    validateVersion(version, entity);

    // TODO: 16/12/8 validate if has product

    productTypeRepository.delete(id);

    // TODO: 16/12/8 send a message

    LOG.debug("end deleteProductTypeById, id is : {}, version is : {}", id, version);
  }

  /**
   * Delete ProductType by key.
   *
   * @param key     the key
   * @param version the version
   */
  public void deleteProductTypeByKey(String key, Integer version) {
    LOG.debug("enter deleteProductTypeById, key is : {}, version is : {}", key, version);

    ProductTypeEntity entity = getProductTypeEntityByKey(key);
    validateVersion(version, entity);

    // TODO: 16/12/8 validate if has product

    productTypeRepository.delete(entity);

    // TODO: 16/12/8 send a message

    LOG.debug("end deleteProductTypeById, key is : {}, version is : {}", key, version);
  }

  /**
   * Update ProductType by id.
   *
   * @param id      the id
   * @param version the version
   * @param actions the actions
   * @return the updated ProductType
   */
  public ProductType updateProductTypeById(String id, Integer version, List<UpdateAction> actions) {
    LOG.debug("enter updateProductTypeById, id is : {}, version is : {}, update actions is : {}",
        id, version, actions);
    ProductTypeEntity entity = getProductTypeEntityById(id);
    ProductType result = updateProductTypeEntity(version, actions, entity);
    LOG.debug("end updateProductTypeById, updated ProductType is {}", result.toString());
    return result;
  }

  /**
   * Update ProductType by key.
   *
   * @param key      the key
   * @param version the version
   * @param actions the actions
   * @return the updated ProductType
   */
  public ProductType updateProductTypeByKey(String key, Integer version,
                                            List<UpdateAction> actions) {
    LOG.debug("enter updateProductTypeByKey, key is : {}, version is : {}, update actions is : {}",
        key, version, actions);
    ProductTypeEntity entity = getProductTypeEntityByKey(key);
    ProductType result = updateProductTypeEntity(version, actions, entity);
    LOG.debug("end updateProductTypeByKey, updated ProductType is {}", result.toString());
    return result;
  }

  /**
   * Gets product type by id.
   *
   * @param id the id
   * @return the product type by id
   */
  public ProductType getProductTypeById(String id) {
    LOG.debug("enter getProductTypeById, id is:{}", id);
    ProductTypeEntity entity = getProductTypeEntityById(id);
    ProductType result = ProductTypeMapper.entityToModel(entity);
    LOG.debug("end getProductTypeById, get ProductType:{}", result.toString());
    return result;
  }

  /**
   * Gets product type by key.
   *
   * @param key the key
   * @return the product type by key
   */
  public ProductType getProductTypeByKey(String key) {
    LOG.debug("enter getProductTypeByKey, key is : {}", key);
    ProductTypeEntity entity = getProductTypeEntityByKey(key);
    ProductType result = ProductTypeMapper.entityToModel(entity);
    LOG.debug("end getProductTypeByKey, get ProductType : {}", result.toString());
    return result;
  }

  /**
   * validate version.
   *
   * @param version the version
   * @param entity  the entity
   */
  private void validateVersion(Integer version, ProductTypeEntity entity) {
    if (!Objects.equals(version, entity.getVersion())) {
      LOG.debug("Version not match, input version:{}, entity version:{}",
          version, entity.getVersion());
      throw new ConflictException("Version not match");
    }
  }

  /**
   * Gets product type entity by key.
   *
   * @param key the key
   * @return the product type entity
   */
  private ProductTypeEntity getProductTypeEntityByKey(String key) {
    ProductTypeEntity entity = productTypeRepository.findDistinctProductTypeByKey(key);
    if (entity == null) {
      LOG.debug("can not find product type by key : {}", key);
      throw new NotExistException("ProductType not exist");
    }
    return entity;
  }

  /**
   * Gets product type entity by id.
   *
   * @param id the id
   * @return the product type entity by id
   */
  private ProductTypeEntity getProductTypeEntityById(String id) {
    ProductTypeEntity entity = productTypeRepository.findOne(id);
    if (entity == null) {
      LOG.debug("can not find product type by id:{}", id);
      throw new NotExistException("ProductType not exist");
    }
    return entity;
  }

  /**
   * update ProductTypeEntity.
   * @param version the version
   * @param actions the update actions
   * @param entity the entity
   * @return updated ProductType
   */
  private ProductType updateProductTypeEntity(Integer version, List<UpdateAction> actions,
                                                    ProductTypeEntity entity) {
    validateVersion(version, entity);
    actions.parallelStream().forEach(action -> ProductTypeUpdateMapper.getMapper(action.getClass())
        .setAction(entity, action));
    ProductTypeEntity updatedEntity = productTypeRepository.save(entity);
    return ProductTypeMapper.entityToModel(updatedEntity);
  }
}
