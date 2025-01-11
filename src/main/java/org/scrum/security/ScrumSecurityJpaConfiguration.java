package org.scrum.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/*
* UserDetailsService bean is provided by the ScrumUserDetailsServiceImpl
* UNCOMMENT @Service annotation
 */
@Configuration @EnableWebSecurity
public class ScrumSecurityJpaConfiguration {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/rest/**").hasAuthority("MEMBER")
                        .requestMatchers("/data/projects/**").hasAuthority("MEMBER")
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults())
                .csrf((csrf) -> csrf.disable())
                //.csrf((csrf) -> csrf.ignoringRequestMatchers("/data/projects/**"))
                .build();
    }
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}