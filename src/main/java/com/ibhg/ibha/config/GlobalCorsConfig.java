package com.ibhg.ibha.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

@Configuration
public class GlobalCorsConfig {

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();

        // Allow credentials (e.g. cookies, Authorization headers)
        config.setAllowCredentials(true);

        // Allowed frontend origins (production + local dev)
        config.setAllowedOrigins(List.of(
            "https://ib-hfrontend.vercel.app",
            "http://localhost:5173"
        ));

        // Allow all headers
        config.setAllowedHeaders(List.of("*"));

        // Allow all HTTP methods
        config.setAllowedMethods(Arrays.asList(
            "GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS", "HEAD"
        ));

        // Optional: expose some headers to the frontend
        config.setExposedHeaders(List.of("Authorization", "Content-Type"));

        // Register this configuration for all routes
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return source;
    }
}
