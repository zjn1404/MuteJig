package com.TripleT.MuteJig;

import com.TripleT.MuteJig.entity.Permission;
import com.TripleT.MuteJig.entity.Role;
import com.TripleT.MuteJig.entity.User;
import com.TripleT.MuteJig.repository.RoleRepository;
import com.TripleT.MuteJig.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class MuteJigApplication {



	public static void main(String[] args) {
		SpringApplication.run(MuteJigApplication.class, args);


	}

//	@Bean
	CommandLineRunner init(RoleRepository roleRepository) {
		return args -> {
			Set<Permission> permissions = new HashSet<>();
			permissions.add(Permission.builder()
					.name("bo thien ha")
					.description("nhu ten")
					.build());
			permissions.add(Permission.builder()
					.name("con thien ha")
					.description("deo cho")
					.build());

			Role god  = Role.builder()
					.name("wibu")
					.description("wibu dinh xa hoi")
					.permissions(permissions)
					.build();
			roleRepository.save(god);
		};
	}

}
