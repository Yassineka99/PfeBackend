package com.example.process.management.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.process.management.Model.Product;
import com.example.process.management.Repository.ProductRepository;

@Service

public class ProductService {
    @Autowired
    ProductRepository productRepository ;
    public Product saveProduct(Product product)
    {
        return productRepository.save(product);
    }
    public Optional<Product> getProductByID(Long id )
    {
        return productRepository.findById(id);
    }
}
