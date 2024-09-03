package com.example.sales_compass.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.sales_compass.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecuirtyConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(request -> request
            .requestMatchers("/endpoint1").permitAll()
            .requestMatchers("/endpoint2").hasRole("ss")
            .requestMatchers("/endpoint3").hasAnyAuthority("read","write")
            .requestMatchers("/endpoint4").hasAnyAuthority("read")
            .anyRequest().authenticated()
        ).formLogin(form->form.permitAll())
        .logout(logout->logout.permitAll());
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        return new CustomUserDetailsService();
    }
    
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
