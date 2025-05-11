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

@Setter
@Getter
@Entity
@Table(name = "chat")
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column(name="from_user")
    private Long from_user;
    @Column(name="to_user")
    private Long to_user;
    @Column(name="message")
    private String message ;
    @Column(name="from_user_date")
    private Date from_user_date ;
    @Column(name="to_user_date")
    private Date to_user_date ;
}
