package com.narasena.xmart_grocery_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    return http
      .authorizeHttpRequests(auth -> auth
        .requestMatchers("/graphql", "/graphiql").authenticated()
        .anyRequest().permitAll()
      )
      .httpBasic(basic -> {})
      .csrf(csrf -> csrf.disable())
      .build();
  }
}
