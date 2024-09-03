package com.example.sales_compass.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.sales_compass.model.User;
import com.example.sales_compass.repo.UserRepo;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
// @RequiredArgsConstructor
@NoArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      User user   = userRepo.findByUserName(username)
                    .orElseThrow(()->new UsernameNotFoundException("User Not Found"));
        return new SecuirtyUserService(user);
    }
    
}
