package com.example.process.management.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.process.management.Model.Product;
import com.example.process.management.Model.User;
import com.example.process.management.Service.ProductService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    ProductService productService ;
    @PostMapping("/create")
    public ResponseEntity<Product> CreateProduct(@RequestBody Product product) {
            Product savedproduct = productService.saveProduct(product);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(savedproduct);
    }
        @GetMapping("/getProductById/{id}")
    public Optional<Product> getUserByID(@PathVariable Long id)
    {
        return productService.getProductByID(id);
    }
    
}
