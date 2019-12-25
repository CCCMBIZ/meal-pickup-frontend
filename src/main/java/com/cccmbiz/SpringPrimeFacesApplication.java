package com.cccmbiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
//public class SpringPrimeFacesApplication extends SpringBootServletInitializer {
public class SpringPrimeFacesApplication extends SpringBootServletInitializer {

  public static void main(String[] args) {
    SpringApplication.run(SpringPrimeFacesApplication.class, args);
  }

//  @Override
//  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//    return application.sources(SpringPrimeFacesApplication.class);
//  }
//
//  public static void main(String[] args) throws Exception {
//    SpringApplication.run(SpringPrimeFacesApplication.class, args);
//  }
}

