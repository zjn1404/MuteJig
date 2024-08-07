package com.TripleT.MuteJig.configuration;

import com.TripleT.MuteJig.entity.Role;
import com.TripleT.MuteJig.repository.RoleRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ApplicationInitConfig {

    RoleRepository roleRepository;

    @Bean
    @ConditionalOnProperty(
            prefix = "spring",
            value = "datasource.driverClassName",
            havingValue = "com.mysql.cj.jdbc.Driver"
    )
    public ApplicationRunner applicationRunner() {
        return args -> {
            if (!roleRepository.existsById("ADMIN")) {

                Role adminRole = Role.builder()
                        .name("ADMIN")
                        .build();

                roleRepository.save(adminRole);
            }
        };
    }

}
