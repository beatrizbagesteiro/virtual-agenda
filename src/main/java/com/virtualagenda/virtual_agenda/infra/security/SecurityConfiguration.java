package com.virtualagenda.virtual_agenda.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Autowired
    SecurityFilter securityFilter;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                        .requestMatchers(HttpMethod.POST, "/auth/register").permitAll()
                        .requestMatchers(HttpMethod.POST, "/service").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/service").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/service").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/professional").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/professional").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/professional").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/working_days").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/working_days").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/working_days").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/client").hasAnyRole("ADMIN", "CLIENT")
                        .requestMatchers(HttpMethod.DELETE, "/client").hasAnyRole("ADMIN", "CLIENT")
                        .anyRequest().authenticated()
                )
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
