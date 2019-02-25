package com.hji.dbtools;

import java.awt.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.hji.dbtools.model.Module;

@SpringBootApplication
public class DbtoolsApplication implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(DbtoolsApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
    headers.set("x-okapi-tenant", "diku");
    HttpEntity<String> requestEntity = new HttpEntity<>("parameters", headers);
    
    String url = "http://folio-snapshot-stable.aws.indexdata.com:9130/_/proxy/tenants/diku/modules";
//    HttpEntity<String> responseEntity = restTemplate.exchange(url,HttpMethod.GET, requestEntity, String.class);
//    System.out.println(responseEntity.getBody());
    
    HttpEntity<Object[]> responseEntity = restTemplate.exchange(url,HttpMethod.GET, requestEntity, Object[].class);
    System.out.println(Arrays.deepToString(responseEntity.getBody()));
    
    
    
  }

}
