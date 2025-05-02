package com.example.process.management.Dto;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDto {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private Date createdAt;
    private String password;
    private int role;

    public UserDto() {
    }
    public UserDto(Long id, String name, String email, String phone, Date createdAt, String password, int role) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.createdAt = createdAt;
        this.password = password;
        this.role = role;
    }
}
