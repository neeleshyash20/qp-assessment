package com.grocery.repo;

import com.grocery.Entity.Users;
import com.grocery.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<Users, Long> {
    Optional<Users> findByUsername(String userName);

    UserDto save(UserDto userDto);

}
