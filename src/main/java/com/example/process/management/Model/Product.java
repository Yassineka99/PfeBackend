package com.example.process.management.Model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id ;
    @Column(name="name")
    private String name ;
    @Column(name="status_id")
    private int status_id;
    @Lob
    @Column(name="model_file", columnDefinition = "LONGBLOB")
    private byte[] modelFile;

    @Column(name="model_file_name")
    private String modelFileName;

    @Column(name="model_file_type")
    private String modelFileType;
    
}