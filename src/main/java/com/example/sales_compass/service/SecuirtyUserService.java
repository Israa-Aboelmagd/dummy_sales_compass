package com.example.sales_compass.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.sales_compass.model.Permission;
import com.example.sales_compass.model.Role;
import com.example.sales_compass.model.User;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SecuirtyUserService  implements UserDetails{
    private final User user;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Set<GrantedAuthority> roles = user.getRoles().stream()
        .map(role -> new SimpleGrantedAuthority( role.getName())) // Roles are prefixed with "ROLE_"
        .collect(Collectors.toSet());

        Set<GrantedAuthority> permissions = user.getPermissions().stream()
        .map(permission -> new SimpleGrantedAuthority(permission.getName()))
        .collect(Collectors.toSet());

        roles.addAll(permissions);
        System.out.println("////////////////////////////"+roles.toString());
        return roles;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUserName();
    }
    
}
