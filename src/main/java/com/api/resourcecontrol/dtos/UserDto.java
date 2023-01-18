package com.api.resourcecontrol.dtos;

import com.api.resourcecontrol.enums.GroupName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.Any;

public class UserDto {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotNull
    private GroupName group;

    public GroupName getGroupName() {
        return group;
    }

    public void setGroupName(GroupName group) {
        this.group = group;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
