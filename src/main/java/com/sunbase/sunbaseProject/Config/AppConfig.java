package com.sunbase.sunbaseProject.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.client.RestTemplate;

@Configuration
class MyConfig {

    // Defines a bean for providing user details for authentication.

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails userDetails = User.builder().
                username("test@sunbasedata.com")
                .password(passwordEncoder().encode("Test@123")).roles("ADMIN").
                build();
        return new InMemoryUserDetailsManager(userDetails);
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
        return builder.getAuthenticationManager();
    }


    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


}