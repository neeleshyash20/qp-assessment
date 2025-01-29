//package com.grocery.service;
//
//import com.grocery.Entity.Users;
//import com.grocery.dto.UserDto;
//import com.grocery.repo.UserRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class UsersDetailsServices implements UserDetailsService {
//
//    @Autowired
//    private UserRepo userRepo;
//
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        System.out.print("APPUSR\n" + username);
//        UserDetails usr =  userRepo.findByUsername(username)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
//        System.out.print(usr.getUsername());
//        return usr;
//    }
//
//    public Users saveUser(Users userDto){
//        return userRepo.save(userDto);
//    }
//
//
//}
