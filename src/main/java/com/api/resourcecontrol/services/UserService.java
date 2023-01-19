package com.api.resourcecontrol.services;

import com.api.resourcecontrol.models.FoodModel;
import com.api.resourcecontrol.models.RoleModel;
import com.api.resourcecontrol.models.UserModel;
import com.api.resourcecontrol.repositories.RoleRepository;
import com.api.resourcecontrol.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
/*
    @Autowired
    private RoleRepository roleRepository;
*/

    final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    @Transactional
    public UserModel save(UserModel userModel) {
        return userRepository.save(userModel);
    }

    public Page<UserModel> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }
    public Optional<UserModel> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Transactional
    public void delete(UserModel userModel) {
        userRepository.delete(userModel);
    }


    /*
    public UserModel assignUserToRole(UUID id, UUID roleId) {
        List<RoleModel> roleModelList = null;
        UserModel userModel = userRepository.findById(id).get();
        RoleModel roleModel = roleRepository.findById(roleId).get();
        roleModelList = userModel.getRoles();
        roleModelList.add(roleModel);
        userModel.setRoles(roleModelList);
        return userRepository.save(userModel);
    }

     */
}
