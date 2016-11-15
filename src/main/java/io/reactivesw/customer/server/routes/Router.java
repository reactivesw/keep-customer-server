package io.reactivesw.customer.server.routes;

/**
 * Created by bruceliu on 16/11/14.
 */
public class Router {
    public static final String TEST_API = "/test";
    public static final String CUSTOMER_ID = "customerId";
    // for customer apis
    public static final String CUSTOMER_GET_BY_ID = "/customers/{" + CUSTOMER_ID + "}";
}
