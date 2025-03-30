package com.hunre.edu.laptop.inits;

import com.hunre.edu.laptop.models.Role;
import com.hunre.edu.laptop.models.enums.RoleName;
import com.hunre.edu.laptop.repositories.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitDatabase {
    @Bean
    CommandLineRunner initRole(RoleRepository roleRepository) {
        return args -> {
            if (!roleRepository.existsByName(RoleName.ADMIN)) {
                Role adminRole = new Role();
                adminRole.setName(RoleName.ADMIN);
                roleRepository.save(adminRole);
            }
            if (!roleRepository.existsByName(RoleName.STAFF)) {
                Role staffRole = new Role();
                staffRole.setName(RoleName.STAFF);
                roleRepository.save(staffRole);
            }
            if (!roleRepository.existsByName(RoleName.USER)) {
                Role userRole = new Role();
                userRole.setName(RoleName.USER);
                roleRepository.save(userRole);
            }
        };
    }
}
