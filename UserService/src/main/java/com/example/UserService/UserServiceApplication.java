package com.example.UserService;

import com.example.UserService.model.entity.RoleEntity;
import com.example.UserService.model.entity.UserEntity;
import com.example.UserService.service.UserService;
import com.example.UserService.utils.UserRole;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class UserServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner ru(UserService userService) {
		return args -> {
			Arrays.stream(UserRole.values()).forEach( role -> userService.saveRole(new RoleEntity(null, role)));


			userService.saveUser(new UserEntity(null,"1","A","123", null, null, new ArrayList<>()));
			userService.saveUser(new UserEntity(null,"2","B","123", null, null, new ArrayList<>()));
			userService.saveUser(new UserEntity(null,"3","C","123", null, null, new ArrayList<>()));
			userService.saveUser(new UserEntity(null,"4","D","123", null, null, new ArrayList<>()));

			userService.addRoleToUser("1",UserRole.ROLE_USER);
			userService.addRoleToUser("1",UserRole.ROLE_MANAGER);
			userService.addRoleToUser("2",UserRole.ROLE_MANAGER);
			userService.addRoleToUser("3",UserRole.ROLE_ADMIN);
			userService.addRoleToUser("4",UserRole.ROLE_USER);
			userService.addRoleToUser("4",UserRole.ROLE_ADMIN);
			userService.addRoleToUser("4",UserRole.ROLE_SUPER_ADMIN);
		};
	}

}
