package com.grocery.Grocery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//mport org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication (scanBasePackages = "com.grocery")
@EnableJpaRepositories(basePackages = "com.grocery.repo")
@EntityScan(basePackages = "com.grocery.entity")

public class GroceryApplication {

	public static void main(String[] args) {
		SpringApplication.run(GroceryApplication.class, args);
	}


}
