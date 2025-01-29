package com.grocery.service;

import com.grocery.Entity.Users;
import com.grocery.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServices {

    @Autowired
    private UserRepo userRepo;

//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;


    public Users checkUser( Users users) throws Exception {
     Users usr = userRepo.findByUsername(users.getUsername())
                .orElseThrow(() -> new Exception("User not found"));

        // Compare the stored hashed password with the provided raw password
       if(usr.getPassword().equals(users.getPassword())){
           return usr;
       }
       else{
           return null;
       }
    }

    public Users findUser( String userId) throws Exception{
        Users user = userRepo.findByUsername(userId)
                .orElseThrow(() -> new Exception("User not found"));
        return user;

    }

    public Users saveUser(Users userDto){
        return userRepo.save(userDto);
  }
}
