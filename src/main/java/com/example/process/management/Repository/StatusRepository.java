package com.example.process.management.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.process.management.Model.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status,Long> {
    
}
