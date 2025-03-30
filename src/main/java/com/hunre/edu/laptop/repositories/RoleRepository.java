package com.hunre.edu.laptop.repositories;

import com.hunre.edu.laptop.models.Role;
import com.hunre.edu.laptop.models.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(RoleName name);
    boolean existsByName(RoleName name);
}
