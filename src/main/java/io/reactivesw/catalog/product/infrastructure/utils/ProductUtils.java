package io.reactivesw.catalog.product.infrastructure.utils;

import com.google.common.collect.Lists;

import io.reactivesw.catalog.product.domain.entity.ProductCatalogDataEntity;
import io.reactivesw.catalog.product.domain.entity.ProductDataEntity;
import io.reactivesw.catalog.product.domain.entity.ProductEntity;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Davis on 16/12/23.
 */
public final class ProductUtils {
  /**
   * Instantiates a new Product utils.
   */
  private ProductUtils() {
  }

  /**
   * Gets sku names.
   *
   * @param products the products
   * @return the sku names
   */
  public static List<String> getSkuNames(List<ProductEntity> products) {
    List<String> skuNames = Lists.newArrayList();

    if (products != null && !products.isEmpty()) {
      products.parallelStream().forEach(
          product -> {
            skuNames.addAll(getSkuNames(product));
          }
      );
    }

    return skuNames;
  }

  /**
   * Gets sku names.
   *
   * @param product the product
   * @return the sku names
   */
  public static List<String> getSkuNames(ProductEntity product) {
    List<String> skuNames = Lists.newArrayList();

    ProductCatalogDataEntity masterData = product.getMasterData();
    ProductDataEntity currentData = masterData.getCurrent();
    ProductDataEntity stagedData = masterData.getStaged();

    skuNames.addAll(getSkuNames(currentData));
    skuNames.addAll(getSkuNames(stagedData));

    return skuNames;
  }

  /**
   * Gets sku names.
   *
   * @param productData the product data
   * @return the sku names
   */
  public static List<String> getSkuNames(ProductDataEntity productData) {
    List<String> skuNames = Lists.newArrayList();

    if (productData.getMasterVariant() != null) {
      skuNames.add(productData.getMasterVariant().getSku());
    }

    if (productData.getVariants() != null) {
      skuNames.addAll(productData.getVariants().parallelStream().map(
          variant -> {
            return variant.getSku();
          }
      ).collect(Collectors.toList()));
    }

    return skuNames;
  }
}
