package com.example.sales_compass.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sales_compass.model.Permission;

public interface PermissionRepo extends JpaRepository<Permission,Long>{
    
}
