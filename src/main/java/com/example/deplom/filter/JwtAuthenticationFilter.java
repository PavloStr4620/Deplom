package com.example.deplom.filter;

import com.example.deplom.service.serviceImpl.JwtService;

import com.example.deplom.service.serviceImpl.UserDetailsServiceImp;
import io.micrometer.common.lang.NonNull;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserDetailsServiceImp userDetailsService;


    public JwtAuthenticationFilter(JwtService jwtService, UserDetailsServiceImp userDetailsService) {
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }


    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain)
            throws ServletException, IOException {
        // Перевизначений метод, який фільтрує запити до додатку
        // Він отримує HTTP запит, HTTP відповідь та ланцюжок фільтрів
        // для передачі запитів далі по ланцюжку фільтрів
        String authHeader = request.getHeader("Authorization");
        // Отримання заголовка авторизації з запиту
        if(authHeader == null || !authHeader.startsWith("Bearer ")) {
            // Перевірка, чи заголовок авторизації відсутній або не починається з "Bearer "
            // Якщо так, запустити наступний фільтр у ланцюжку та завершити виконання цього фільтру
            filterChain.doFilter(request,response);
            return;
        }
        // Витягнення токена з заголовка авторизації
        String token = authHeader.substring(7);
        // Вилучення ім'я користувача з токена
        String username = jwtService.extractUsername(token);
        // Перевірка, чи користувача не має вже аутентифіковано в поточному контексті безпеки та чи токен є валідним
        if(username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            // Завантаження деталей користувача за ім'ям користувача
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            // Перевірка валідності токена
            if(jwtService.isValid(token, userDetails)) {
                // Створення об'єкту аутентифікації з деталями користувача та його ролями
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities()
                );
                // Додавання деталей автентифікації до об'єкту аутентифікації
                authToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                );
                // Встановлення аутентифікації в поточному контексті безпеки
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        // Продовження ланцюжка фільтрів
        filterChain.doFilter(request, response);
    }
}


