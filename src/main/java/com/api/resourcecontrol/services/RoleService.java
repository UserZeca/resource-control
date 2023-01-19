package com.api.resourcecontrol.services;

import com.api.resourcecontrol.enums.RoleName;
import com.api.resourcecontrol.models.RoleModel;
import com.api.resourcecontrol.repositories.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Optional<RoleModel> findByRoleName(RoleName roleName){
        return roleRepository.findByRoleName(roleName);
    }

}
