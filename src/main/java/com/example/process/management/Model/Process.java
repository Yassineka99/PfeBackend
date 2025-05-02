package com.example.process.management.Model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Process {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)  
  private Long id ;
  @Column(name="name")
  private String name ;
  @Column (name="workflow_id")
  private Long workflow_id ;
  @Column(name="status_id")
  private Long status_id ;
  @Column(name="process_order")
  private int order ;
  @Column(name="created_by")
  private Long created_by;
  @Column(name="created_at")
  private Date created_at ;
  @Column(name="finished_at")
  private Date finished_at;
  @Column(name="updated_at")
  private Date updated_at ;
  @Column(name="updated_by")
  private Long updated_by ;
}
