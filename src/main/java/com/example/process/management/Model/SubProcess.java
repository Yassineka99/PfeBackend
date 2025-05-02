package com.example.process.management.Model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter

public class SubProcess {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id ;
    @Column(name="name")
    private String name ;
    @Column(name="created_by")
    private Long created_by;
    @Column(name="status")
    private Long status ;
    @Column(name="assigned_to")
    private Long assigned_to ;
    @Column(name="created_at")
    private Date created_at;
    @Column(name="finished_at")
    private Date finished_at ;
    @Column (name="message")
    private String message ;
    @Column(name="process_id")
    private Long process_id ;
}
