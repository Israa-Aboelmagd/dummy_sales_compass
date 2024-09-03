package com.example.sales_compass.service;



import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.sales_compass.model.Permission;
import com.example.sales_compass.model.Role;
import com.example.sales_compass.model.Session;
import com.example.sales_compass.model.User;
import com.example.sales_compass.repo.PermissionRepo;
import com.example.sales_compass.repo.RoleRepo;
import com.example.sales_compass.repo.SessionRepo;
import com.example.sales_compass.repo.UserRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;
    private final SessionRepo sessionRepo;
    private final PasswordEncoder passwordEncoder;
    
    public void createUser(){
        Role r1= Role.builder().name("ss").build();
        Role r2= Role.builder().name("admin").build();
        Permission p1 = Permission.builder()
                        .name("read")
                        .build();
        Permission p2 = Permission.builder()
                        .name("write")
                        .build();
        User user = User.builder().userName("israa")
                    .password(passwordEncoder.encode("123"))
                    .permissions(Set.of(p1,p2))
                    .roles(Set.of(r1,r2))
                    .build();
        Session session = Session.builder().createdAt(LocalDateTime.now())
                        .expiredAt(LocalDateTime.now().plusHours(1))
                        .user(user)
                        .build();
        userRepo.save(user);
        sessionRepo.save(session);
    }

}
