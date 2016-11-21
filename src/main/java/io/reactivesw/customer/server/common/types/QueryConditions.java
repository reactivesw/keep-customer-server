package io.reactivesw.customer.server.common.types;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Davis on 16/11/21.
 */
@ApiModel
public class QueryConditions {

  @ApiModelProperty(required = false)
  String expandId;

  @ApiModelProperty(required = false)
  Integer version;

  /**
   * name(en="Pro T-Shirt")
   */
  @ApiModelProperty(required = false)
  String where;

  /**
   * name.em
   */
  @ApiModelProperty(required = false)
  String sort;

  @ApiModelProperty(required = false)
  String sortOrder;

  @ApiModelProperty(required = false)
  String page;

  @ApiModelProperty(required = false)
  String perPage;

  @ApiModelProperty(required = false)
  String expand;

  @ApiModelProperty(required = false)
  Boolean staged;

  @ApiModelProperty(required = false)
  Boolean stagedId;

  public String getExpandId() {
    return expandId;
  }

  public void setExpandId(String expandId) {
    this.expandId = expandId;
  }

  public Integer getVersion() {
    return version;
  }

  public void setVersion(Integer version) {
    this.version = version;
  }

  public String getWhere() {
    return where;
  }

  public void setWhere(String where) {
    this.where = where;
  }

  public String getSort() {
    return sort;
  }

  public void setSort(String sort) {
    this.sort = sort;
  }

  public String getSortOrder() {
    return sortOrder;
  }

  public void setSortOrder(String sortOrder) {
    this.sortOrder = sortOrder;
  }

  public String getPage() {
    return page;
  }

  public void setPage(String page) {
    this.page = page;
  }

  public String getPerPage() {
    return perPage;
  }

  public void setPerPage(String perPage) {
    this.perPage = perPage;
  }

  public String getExpand() {
    return expand;
  }

  public void setExpand(String expand) {
    this.expand = expand;
  }

  public Boolean getStaged() {
    return staged;
  }

  public void setStaged(Boolean staged) {
    this.staged = staged;
  }

  public Boolean getStagedId() {
    return stagedId;
  }

  public void setStagedId(Boolean stagedId) {
    this.stagedId = stagedId;
  }
}
