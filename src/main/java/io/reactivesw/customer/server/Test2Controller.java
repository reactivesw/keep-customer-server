package io.reactivesw.customer.server;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by bruceliu on 16/11/14.
 */
@RestController
public class Test2Controller {

  RestTemplate restClient = new RestTemplate();

  @GetMapping("/test2")
  public String testApi(){
    String response = this.restClient.getForObject("http://localhost:8080/test",String.class);
    return "test message from test: " + response;
  }
}
