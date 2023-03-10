package com.api.resourcecontrol.repositories;

import com.api.resourcecontrol.enums.RoleName;
import com.api.resourcecontrol.models.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<RoleModel, UUID> {

    Optional<RoleModel> findByRoleName(RoleName roleName);

}
