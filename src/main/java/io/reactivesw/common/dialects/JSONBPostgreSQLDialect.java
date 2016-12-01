package io.reactivesw.common.dialects;

import org.hibernate.dialect.PostgreSQL94Dialect;

import java.sql.Types;

public class JSONBPostgreSQLDialect extends PostgreSQL94Dialect {

  public JSONBPostgreSQLDialect() {
    super();
    registerColumnType(Types.JAVA_OBJECT, JSONBUserType.JSONB_TYPE);
  }
}
