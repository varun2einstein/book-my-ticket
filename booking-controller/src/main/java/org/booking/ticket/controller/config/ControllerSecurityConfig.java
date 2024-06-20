package org.booking.ticket.controller.config;

import org.booking.ticket.auth.service.CustomUserDetailsService;
import org.booking.ticket.auth.service.impl.CustomUserDetailsServiceImpl;
import org.booking.ticket.auth.util.JwtUtil;
import org.booking.ticket.controller.security.filter.JwtAuthenticationFilter;
import org.booking.ticket.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class ControllerSecurityConfig {

    @Value("${security.enabled:true}")
    private boolean seacurityEnabled;

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean(name = "controllerSecurityFilterChain")
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        if(!seacurityEnabled){
            http.authorizeRequests().anyRequest().permitAll();
        }else {
            http.authorizeHttpRequests(authorizeRequests ->
                            authorizeRequests
                                    .requestMatchers("/actuator/**").permitAll()
                                    .anyRequest().authenticated()
                    ).csrf(csrf -> csrf.disable())
                    .sessionManagement(session -> session
                            .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                    .cors(cors -> cors.disable());

            http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        }
        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/auth/**");
    }

}