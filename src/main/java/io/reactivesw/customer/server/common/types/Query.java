package io.reactivesw.customer.server.common.types;

/**
 * Created by Davis on 16/11/21.
 */
public class Query {
  String expandId;

  Integer version;

  /**
   * name(en="Pro T-Shirt")
   */
  String where;

  /**
   * name.em
   */
  String sort;

  String sortOrder;

  String page;

  String perPage;

  String expand;

  Boolean staged;

  Boolean stagedId;
}
