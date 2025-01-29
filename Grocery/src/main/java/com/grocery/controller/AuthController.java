package com.grocery.controller;

import com.grocery.Entity.Users;
import com.grocery.dto.UserDto;
//import com.grocery.security.JwtUtill;
import com.grocery.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserServices userServices;

//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;
//
//    @Autowired
//    private JwtUtill jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<String> login (@RequestBody Users  users) throws Exception {
        Users isValidUser = userServices.checkUser(users);

        if (isValidUser != null) {
            // Generate a JWT token if the user is valid
            //String token = jwtUtil.generateToken(users.getUsername(), users.getRole());  // Assuming role is part of user
            return ResponseEntity.ok("logged in "+users);  // Return token as response
        } else {
            throw new Exception("Invalid credentials");  // Throw an exception if user is invalid
        }

    }

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody Users users){
        Users userDto = new Users();

        //String encodedPassword = passwordEncoder.encode(users.getPassword());
        userDto.setUsername(users.getUsername());
        //userDto.setPassword(encodedPassword);
        userDto.setPassword(users.getPassword());
        userDto.setEmail(users.getEmail());
        userDto.setRole(users.getRole());
        userServices.saveUser(userDto);
        return ResponseEntity.ok("User Saved Successfully" + userDto);
    }
}
