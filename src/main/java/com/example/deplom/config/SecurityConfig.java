package com.example.deplom.config;

import com.example.deplom.filter.JwtAuthenticationFilter;
import com.example.deplom.service.serviceImpl.UserDetailsServiceImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final UserDetailsServiceImp userDetailsServiceImp;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public SecurityConfig(UserDetailsServiceImp userDetailsServiceImp, JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.userDetailsServiceImp = userDetailsServiceImp;
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        req -> req.requestMatchers(
                                        "/main",
                                        "/addToCart",
                                        "/cart/**",
                                        "/add-product-db/**",
                                        "/cart/an-Order/**",
                                        "/an-Order/**",
                                        "/userOrders/**",
                                        "/profile/**",
                                        "/camera-page/**",
                                        "/page-create-camera/**",
                                        "/camera-page/search-camera/**",
                                        "/page-update-camera",
                                        "/tripod-page/**",
                                        "/tripod-page/search-tripod/**",
                                        "/page-tripod-id/**",
                                        "/lens-page/**",
                                        "/lens-page/search-lens/**",
                                        "/lens-page/page-create-lens/**",
                                        "/registerPage",
                                        "/auth/login/**",
                                        "/loginPage",
                                        "/auth/register/**").permitAll()
                                .requestMatchers(
                                        "/admin/**",
                                        "/updateUserRole",
                                        "/adminUserList/**",
                                        "/admin/editOrderStatus/**",
                                        "/admin/updateOrderStatus/**",
                                        "/users/find-by-id/**",
                                        "/updateOrderStatus/**",
                                        "/editOrderStatus/**",
                                        "/users/get-All-Users/**",
                                        "/camera/**",
                                        "/lens/",
                                        "tripod/**").hasAnyAuthority("ADMIN")
                                .anyRequest()
                                .authenticated()
                )
                .userDetailsService(userDetailsServiceImp)
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
}
