package com.example.sales_compass.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sales_compass.model.Session;

public interface SessionRepo extends JpaRepository<Session,Long>{
    
}
