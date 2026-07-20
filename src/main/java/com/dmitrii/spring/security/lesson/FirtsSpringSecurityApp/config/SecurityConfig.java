package com.dmitrii.spring.security.lesson.FirtsSpringSecurityApp.config;

import com.dmitrii.spring.security.lesson.FirtsSpringSecurityApp.security.CustomAuthProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author : Dmitrii Frolov, a.k.a. A1Rinzler
 * @created : 13.07.2026
 **/
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final CustomAuthProviderImpl customAuthProvider;

    @Autowired
    public SecurityConfig(CustomAuthProviderImpl customAuthProvider) {
        this.customAuthProvider = customAuthProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .authorizeHttpRequests(auth->auth.anyRequest().authenticated())
                .formLogin(Customizer.withDefaults())
                .authenticationProvider(customAuthProvider);
        return httpSecurity.build();
    }
}
