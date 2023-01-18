package com.api.resourcecontrol.controllers;


import com.api.resourcecontrol.dtos.UserDto;
import com.api.resourcecontrol.models.UserModel;
import com.api.resourcecontrol.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/user")
public class UserController {

    final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<Page<UserModel>> getAllUsers(@PageableDefault(page = 0 , size = 10, sort = "userId", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAll(pageable));
    }

    @GetMapping("/search/{username}")
    public ResponseEntity<Object> getOneUser(@PathVariable(value = "username")String username){
        Optional<UserModel> userModelOptional = userService.findByUsername(username);

        if(!userModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }

        return ResponseEntity.status((HttpStatus.OK)).body(userModelOptional.get());
    }

    @PostMapping("/signIn/create")
    public ResponseEntity<Object> saveUser(@RequestBody @Valid UserDto userDto){

        System.out.println("grupName: "+ userDto.getGroupName());

        var userModel = new UserModel(
                userDto.getUsername(),
                userDto.getPassword(),
                userDto.getGroupName()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userModel));
    }

    private void setUserForBasicRole(UserModel userModel){



    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody String username, @RequestBody String password ){
        /*
        Optional<UserModel> userModelOptional = userService.findByUsername(username);

        if(!userModelOptional.isPresent() && !userModelOptional.get().getPassword().equals(password)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
        */
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Login with success!");
    }


    @DeleteMapping("/delete/{username}")
    public ResponseEntity<Object> delete(@PathVariable(value = "username")String username) {
        Optional<UserModel> userModelOptional = userService.findByUsername(username);

        if(!userModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
        userService.delete(userModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("User deleted successfully.");

    }

}
