package com.narasena.xmart_grocery_api.graphql;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class HelloResolver {
  
  @QueryMapping
  public String hello() {
    return "Hello GraphQL";
  }
}