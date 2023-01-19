package com.api.resourcecontrol.models;

import com.api.resourcecontrol.enums.GroupName;
import com.api.resourcecontrol.enums.RoleName;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "TB_USER")
//@OnDelete(action = OnDeleteAction.CASCADE)
public class UserModel implements UserDetails, Serializable {
    private static final long serialVersionUID = 1L;

    public UserModel(){
    }

    public UserModel(String username, String password, GroupName groupName){
        this.username = username;
        this.password = password;
        this.groupName = groupName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID userId;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GroupName groupName;

    public GroupName getGroup() {
        return this.groupName;
    }

    public void setGroup(GroupName groupName) {
        this.groupName = groupName;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "TB_USER_ROLES",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<RoleModel> roles;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "TB_USER_FOOD",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "food_id")
    )
    private List<FoodModel> foodModels;

    public List<FoodModel> getFoodModels() {
        return foodModels;
    }

    public void setFoodModels(List<FoodModel> foodModels) {
        this.foodModels = foodModels;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles;
    }


    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<RoleModel> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleModel> roles) {
        this.roles = roles;
    }
}
