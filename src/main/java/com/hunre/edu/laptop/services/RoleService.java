package com.hunre.edu.laptop.services;

import com.hunre.edu.laptop.models.Role;
import com.hunre.edu.laptop.models.enums.RoleName;

public interface RoleService {
    Role findByName(RoleName name);
}
