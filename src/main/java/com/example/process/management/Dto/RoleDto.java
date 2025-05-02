package com.example.process.management.Dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RoleDto {
    public Long id ;
    public String name ;
    public RoleDto(){}
    public RoleDto(Long id , String name)
    {
        this.id=id ;
        this.name=name ;
    }
}
