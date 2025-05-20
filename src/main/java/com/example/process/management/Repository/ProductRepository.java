package com.example.process.management.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.process.management.Model.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{
    
}
