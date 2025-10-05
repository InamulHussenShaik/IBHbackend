package com.ibhg.ibha.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.List;

@Configuration
public class GlobalCorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);

        // ✅ Only include your known frontend origins
        config.setAllowedOriginPatterns(List.of(
                "https://ib-hfrontend.vercel.app",
                "http://localhost:5173"
        ));

        // ✅ Allow all headers and methods
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");

        // ✅ Expose authorization header for frontend access (if needed)
        config.addExposedHeader("Authorization");

        // ✅ Apply to all paths
        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }
}
