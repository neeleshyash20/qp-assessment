//package com.grocery.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
////
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.context.annotation.Bean;
////import org.springframework.context.annotation.Configuration;
////import org.springframework.security.config.annotation.web.builders.HttpSecurity;
////import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//////import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
////import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
////import org.springframework.security.crypto.password.PasswordEncoder;
////import org.springframework.security.web.SecurityFilterChain;
////import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
////
////@Configuration
//////@EnableWebSecurity
////public class SecurityConfig {
////
//////    @Autowired
//////    private JwtAuthenticationFilter jwtAuthenticationFilter;
//////
//////    @Autowired
//////    private JwtUtill jwtUtil;
//////
//////    @Bean
//////    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//////        http
//////                .csrf(csrf -> csrf.disable())  // Disable CSRF protection
//////                .authorizeHttpRequests(auth -> auth
//////                        .requestMatchers("/login", "/signup").permitAll()   // Allow login and signup without authentication
//////                                .requestMatchers("/grocery/**").hasRole("ADMIN")   // Admin can access grocery endpoints
//////                                .requestMatchers("/orders").hasRole("CUSTOMER")   // Customer can access order endpoints
//////                                .anyRequest().authenticated()  // Other requests need to be authenticated
//////                )
//////                .addFilterBefore(new JwtAuthenticationFilter(jwtUtil), UsernamePasswordAuthenticationFilter.class);  // Add custom JWT filter
//////
//////        return http.build();
//////    }
////
////    // Password encoder bean (for BCrypt encoding)
//////    @Bean
//////    public PasswordEncoder passwordEncoder() {
//////        return new BCryptPasswordEncoder();
//////    }
////
////}
////
////
//@Configuration
//public class SecurityConfig {
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}