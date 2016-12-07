package io.reactivesw.common.dialect;

import org.hibernate.dialect.PostgreSQL94Dialect;

import java.sql.Types;

public class JSONBPostgreSQLDialect extends PostgreSQL94Dialect {

  public JSONBPostgreSQLDialect() {
    super();
    registerColumnType(Types.JAVA_OBJECT, JSONBUserType.JSONB_TYPE);
  }
}
