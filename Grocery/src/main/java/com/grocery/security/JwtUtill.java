//package com.grocery.security;
//
//import io.jsonwebtoken.*;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//@Component
//public class JwtUtill {
//        private final String SECRET_KEY = "root@123"; // Use a secure key and keep it private
//        private final long EXPIRATION_TIME = 1000 * 60 * 60; // 1 hour in milliseconds
//
//        // Generate token
//        public String generateToken(String username, String role) {
//            return Jwts.builder()
//                    .setSubject(username)
//                    .claim("role", role) // Add the role claim
//                    .setIssuedAt(new Date())
//                    .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
//                    .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
//                    .compact();
//        }
//
//        // Validate token
//        public boolean validateToken(String token) {
//            try {
//                Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
//                return true;
//            } catch (ExpiredJwtException | MalformedJwtException | UnsupportedJwtException | IllegalArgumentException e) {
//                e.printStackTrace();
//                return false;
//            }
//        }
//
//        // Extract username
//        public String extractUsername(String token) {
//            return Jwts.parser()
//                    .setSigningKey(SECRET_KEY)
//                    .parseClaimsJws(token)
//                    .getBody()
//                    .getSubject();
//        }
//
//        // Extract role
//        public String extractRole(String token) {
//            return Jwts.parser()
//                    .setSigningKey(SECRET_KEY)
//                    .parseClaimsJws(token)
//                    .getBody()
//                    .get("role", String.class);
//        }
//}
//
//
