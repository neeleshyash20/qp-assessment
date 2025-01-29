//package com.grocery.security;
//
//import jakarta.servlet.*;
//import jakarta.servlet.annotation.WebFilter;
//import jakarta.servlet.http.HttpServletRequest;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.io.IOException;
//
//@WebFilter("/grocery/**")
//public class JwtAuthenticationFilter {
//
//
//    @Autowired
//    private JwtUtill jwtUtil;
//
//    public void init(FilterConfig filterConfig) throws ServletException {
//    }
//
//
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//            throws IOException, ServletException {
//
//        HttpServletRequest httpRequest = (HttpServletRequest) request;
//
//        // Get the Authorization header
//        String authorizationHeader = httpRequest.getHeader("Authorization");
//
//        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
//            String token = authorizationHeader.substring(7);  // Remove "Bearer " prefix
//
//            // Validate the token
//            if (jwtUtil.validateToken(token)) {
//                // If valid, continue the request
//                chain.doFilter(request, response);
//            } else {
//                // If invalid, return error
//                throw new ServletException("Invalid token");
//            }
//        } else {
//            throw new ServletException("Authorization header missing or incorrect format");
//        }
//    }
//
//
//    public void destroy() {
//    }
//}
