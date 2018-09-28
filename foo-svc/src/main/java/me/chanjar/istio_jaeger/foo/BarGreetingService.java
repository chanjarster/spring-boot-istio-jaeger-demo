package me.chanjar.istio_jaeger.foo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BarGreetingService {

  private final RestTemplate restTemplate;

  public BarGreetingService(RestTemplateBuilder restTemplateBuilder, @Value("${bar-svc.url}") String barSvcUrl) {
    this.restTemplate = restTemplateBuilder.rootUri(barSvcUrl).build();
  }

  public String greeting() {
    return restTemplate.getForObject("/greeting?name=foo-svc", String.class);
  }

}
