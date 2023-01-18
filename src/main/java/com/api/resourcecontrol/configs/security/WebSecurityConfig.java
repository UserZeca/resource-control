package com.api.resourcecontrol.configs.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .httpBasic()
                .and()
                .authorizeHttpRequests()
                .requestMatchers(HttpMethod.GET, "/user/**").hasAnyRole("ADMIN")
                .requestMatchers(HttpMethod.POST, "/user/signIn/**").permitAll()
                .requestMatchers(HttpMethod.DELETE, "/user/delete/").hasRole("ADMIN")
                .requestMatchers(HttpMethod.GET, "/food/**").hasAnyRole("USER", "ADMIN")
                .requestMatchers(HttpMethod.POST,"/food").hasRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/food/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.PUT, "/food/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .csrf().disable();
        return  http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
