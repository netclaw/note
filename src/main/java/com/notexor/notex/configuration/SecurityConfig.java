package com.notexor.notex.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.notexor.notex.service.CompteService;

import jakarta.annotation.Resource;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true, // (1) The prePostEnabled property enables support for Spring’s
                                             // @PreAuthorize and @PostAuthorize
        securedEnabled = true, // (2) The securedEnabled property enables support for the @Secured
        jsr250Enabled = true) // (3) The jsr250Enabled property enables support for the @RolesAllowed
public class SecurityConfig {

    @Resource
    private CompteService compteService;

    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(compteService);
        authProvider.setPasswordEncoder(bCryptPasswordEncoder());
        return authProvider;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                // .requestMatchers("/").permitAll()
                .requestMatchers("/h2-console/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and().csrf().disable()// don't apply CSRF protection to /h2-console
                .headers().frameOptions().disable();// allow use of frame to same origin urls;

        return http.build();

    }

}
