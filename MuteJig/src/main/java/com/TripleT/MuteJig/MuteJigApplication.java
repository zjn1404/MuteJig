package com.TripleT.MuteJig;

import com.TripleT.MuteJig.entity.User;
import com.TripleT.MuteJig.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MuteJigApplication {



	public static void main(String[] args) {
		SpringApplication.run(MuteJigApplication.class, args);


	}

	@Bean
	CommandLineRunner init(UserRepository userRepository) {
		return args -> {
			User user = new User("1234", "tuong123", "12345", "tuong@gmail.com", true);

			System.out.println(userRepository.save(user));
		};
	}

}
