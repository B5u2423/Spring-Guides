package com.demo.secureweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // authorize.requestMatchers("/uri").permitAll() = allow every request to endpoint `/uri` without authentication
        http.authorizeHttpRequests(authorize -> authorize.anyRequest().authenticated()).formLogin(
                    Customizer.withDefaults())
            .rememberMe(Customizer.withDefaults());
        return http.build();
    }

    // user1:user1
    // In production setting, it is recommended to hash the password ahead of time.
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails userDetails = User.withUsername("user1").password(
                "{bcrypt}$2a$10$1Gbg9lLtgYUYLyngbjP5reiZbNP5Qpa6ZMQnlzs2muqwPvLaYpLIO").roles("USER").build();

        return new InMemoryUserDetailsManager(userDetails);
    }
}
