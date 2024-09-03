package com.example.sales_compass.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sales_compass.model.Role;

public interface RoleRepo extends JpaRepository<Role,Long>{
    
}
