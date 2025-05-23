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
@Table(name = "Workflow")
public class Workflow {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @Column(name="name")
    private String name ;
    @Column(name="created_by")
    private Long created_by ;
    @Column(name="status_id")
    private Integer status_id;
    @Column(name="product_id")
    private Long product_id;
    @Column(name="quantity")
    private Integer qty ;
    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String image;
    @Column(name = "image_type")
    private String imageType;

}
