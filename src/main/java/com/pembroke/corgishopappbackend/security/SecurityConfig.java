package com.pembroke.corgishopappbackend.security;

import com.pembroke.corgishopappbackend.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserDetailsService userDetailsService;
    private final AuthEntryPoint authEntryPoint;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SecurityConfig(UserDetailsService userDetailsService, AuthEntryPoint authEntryPoint, PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.authEntryPoint = authEntryPoint;
        this.passwordEncoder = passwordEncoder;
    }

    /*
@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.csrf(AbstractHttpConfigurer::disable)
            .exceptionHandling(exception -> exception.authenticationEntryPoint(authEntryPoint))
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(authorize -> authorize
                    .requestMatchers("/api/corgis").hasAnyRole("USER"))
                    // .anyRequest().permitAll())
            .authenticationProvider(authenticationProvider())
            .addFilterBefore(basicAuthenticationFilter(), BasicAuthenticationFilter.class);

    return http.build();
}

     */

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.exceptionHandling(exception -> exception.authenticationEntryPoint(authEntryPoint));
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.authorizeHttpRequests(auth -> auth
                .requestMatchers(new AntPathRequestMatcher("/api/corgis")).hasRole("USER")
                .requestMatchers("/api/user/signIn", "/error").permitAll()
                .anyRequest().authenticated());
                //.requestMatchers(new AntPathRequestMatcher("/api/corgis")).authenticated());

        http.csrf(AbstractHttpConfigurer::disable);

        http.authenticationProvider(authenticationProvider());

        http.httpBasic(withDefaults());

        return http.build();
    }

    @Bean
    public com.pembroke.corgishopappbackend.security.BasicAuthenticationFilter basicAuthenticationFilter() {
        return new com.pembroke.corgishopappbackend.security.BasicAuthenticationFilter();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder);
        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}