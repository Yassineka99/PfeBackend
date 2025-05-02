package com.example.process.management.Dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StatusDto {
    public Long id ;
    public String name ;
    public StatusDto(){}
    public StatusDto(Long id , String name)
    {
        this.id=id ;
        this.name=name ;
    }
}
