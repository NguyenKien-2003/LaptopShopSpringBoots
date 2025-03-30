package com.hunre.edu.laptop.services.impls;

import com.hunre.edu.laptop.models.Role;
import com.hunre.edu.laptop.models.enums.RoleName;
import com.hunre.edu.laptop.repositories.RoleRepository;
import com.hunre.edu.laptop.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public Role findByName(RoleName name) {
        return roleRepository.findByName(name);
    }
}
