package com.gabr.e_commerce.security;

import com.gabr.e_commerce.utility.JwtFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtFilter jwtFilter;
    @Bean
    SecurityFilterChain filterChain (HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(
                        configure -> configure
                                .requestMatchers("/users/register","/users/login").permitAll()
                                .requestMatchers(HttpMethod.GET,"/products").hasRole("USER")
                )
                .csrf(AbstractHttpConfigurer::disable)
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .build();

    }

}
