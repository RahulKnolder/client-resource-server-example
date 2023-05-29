package com.knoldus.resourcesercer;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

public class ResourceServerConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authorize)->authorize
                                                        .anyRequest().authenticated()).httpBasic(Customizer.withDefaults());
        return http.build();

    }
}
