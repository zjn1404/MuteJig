package com.TripleT.MuteJig;

import com.TripleT.MuteJig.entity.Role;
import com.TripleT.MuteJig.entity.User;
import com.TripleT.MuteJig.entity.UserDetail;
import com.TripleT.MuteJig.repository.RoleRepository;
import com.TripleT.MuteJig.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Date;
import java.util.Set;

@SpringBootApplication
public class MuteJigApplication {



	public static void main(String[] args) {
		SpringApplication.run(MuteJigApplication.class, args);


	}

	@Bean
	CommandLineRunner init(UserRepository userRepository, RoleRepository roleRepository) {
		return args -> {

			User user = new User();
			user.setId("user123");
			user.setUsername("zjn123");
			user.setPassword("password");
			user.setEmail("zjn@example.com");

			UserDetail userDetail = new UserDetail();
			userDetail.setId(user.getId());
			userDetail.setFirstName("Zjn");
			userDetail.setLastName("Zjn");
			userDetail.setPhoneNumber("1234567890");
			userDetail.setDob(Date.valueOf("2004-04-14"));

			user.setUserDetail(userDetail);
			userDetail.setUser(user);

			Role role = new Role();
			role.setName("ADMIN");
			user.setRoles(Set.of(role));

			userRepository.save(user);
		};
	}

}
