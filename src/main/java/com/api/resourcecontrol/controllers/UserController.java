package com.api.resourcecontrol.controllers;


import com.api.resourcecontrol.dtos.UserDto;
import com.api.resourcecontrol.enums.RoleName;
import com.api.resourcecontrol.models.RoleModel;
import com.api.resourcecontrol.models.UserModel;
import com.api.resourcecontrol.services.RoleService;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/user")
public class UserController {

    final UserService userService;
    final RoleService roleService;



    public UserController(UserService userService, RoleService roleService){
        this.userService = userService;
        this.roleService = roleService;

    }


    @GetMapping("/search")
    public ResponseEntity<Page<UserModel>> getAllUsers(@PageableDefault(page = 0 , size = 10, sort = "userId", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAll(pageable));
    }

    @GetMapping("/search/{username}")
    public ResponseEntity<Object> getOneUser(@PathVariable(value = "username")String username){


        System.out.println(roleService.findByRoleName(RoleName.ROLE_USER).get().getRoleId());

        Optional<UserModel> userModelOptional = userService.findByUsername(username);

        if(!userModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }

        return ResponseEntity.status((HttpStatus.OK)).body(userModelOptional.get());
    }

    @PostMapping("/signIn/create/")
    public ResponseEntity<Object> saveUser(@RequestBody @Valid UserDto userDto){

        System.out.println("grupName: "+ userDto.getGroupName());

        var userModel = new UserModel(
                userDto.getUsername(),
                userDto.getPassword(),
                userDto.getGroupName()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userModel));
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody String username, @RequestBody String password ){


        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Login with success!");
    }

    @PutMapping("/signIn/access/{username}")
    public ResponseEntity<Object> setBasicRole(@PathVariable(value = "username") String username,
                                               @RequestBody UserDto userDto
    ){

        Optional<UserModel> userModelOptional = userService.findByUsername(username);


        if(!userModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }

        List<RoleModel> roleModelList = new ArrayList<RoleModel>();
        var roleModel = new RoleModel();
        var userModel = new UserModel();

        roleModel.setRoleId(roleService.findByRoleName(RoleName.ROLE_USER).get().getRoleId());
        roleModel.setRoleName(RoleName.ROLE_USER);

        roleModelList.add(roleModel);

        userModelOptional.get().setRoles(roleModelList);

        BeanUtils.copyProperties(userDto,userModel);

        userModel.setUserId(userModelOptional.get().getUserId());
        userModel.setUsername(userModelOptional.get().getUsername());
        userModel.setPassword(userModelOptional.get().getPassword());
        userModel.setGroup(userModelOptional.get().getGroup());
        userModel.setRoles(userModelOptional.get().getRoles());


        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userModel));
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
