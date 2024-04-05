package com.sunbase.sunbaseProject.Config;
//
//import com.sumbaseassignment.Security.JwtAuthenticationEntryPoint;
//import com.sumbaseassignment.Security.JwtAuthenticationFilter;
import com.sunbase.sunbaseProject.Security.JwtAuthenticationEntryPoint;
import com.sunbase.sunbaseProject.Security.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {


    @Autowired
    private JwtAuthenticationEntryPoint point;
    @Autowired
    private JwtAuthenticationFilter filter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable())
                // Configures URL permissions, allowing access to certain paths without authentication.
                .authorizeRequests().
                requestMatchers("/home/**").authenticated().requestMatchers("/sunbase/portal/api/assignment_auth.jsp").permitAll()
                .anyRequest()
                .authenticated()
                // Configures exception handling, specifying the authentication entry point.
                .and().exceptionHandling(ex -> ex.authenticationEntryPoint(point))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        // Adds a custom JWT authentication filter before the UsernamePasswordAuthenticationFilter.
        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
        // Builds and returns the configured security filter chain.
        return http.build();
    }


}
