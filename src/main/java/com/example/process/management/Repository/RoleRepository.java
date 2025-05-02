package com.example.process.management.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.process.management.Model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    
}
