package com.example.sales_compass.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sales_compass.model.User;
import java.util.Optional;


public interface UserRepo extends JpaRepository<User,Long> {
    
    Optional<User> findByUserName(String userName);
}
