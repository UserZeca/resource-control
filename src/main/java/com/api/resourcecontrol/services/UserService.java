package com.api.resourcecontrol.services;

import com.api.resourcecontrol.models.FoodModel;
import com.api.resourcecontrol.models.UserModel;
import com.api.resourcecontrol.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

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

}
