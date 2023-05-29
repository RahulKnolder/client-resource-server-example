//package com.knoldus.resourcesercer;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.oauth2.jwt.JwtDecoder;
//import org.springframework.security.oauth2.jwt.JwtDecoders;
//import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
//
//@Configuration
//public class SecurityConfig {
//    @Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
//    private String issuerUri;
//
//    @Bean
//    public JwtDecoder jwtDecoder() {
//        NimbusJwtDecoder jwtDecoder = (NimbusJwtDecoder) JwtDecoders.fromIssuerLocation(issuerUri);
//        return jwtDecoder;
//    }
//}
