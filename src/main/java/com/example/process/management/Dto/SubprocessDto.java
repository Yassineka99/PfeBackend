package com.example.process.management.Dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SubprocessDto {
    public Long id ;
    public String name ;
    public Long created_by;
    public Long status;
    public Long assigned_to ; 
    public Date created_at ;
    public Date finished_at;
    public String message ;
    public SubprocessDto(){}
    public SubprocessDto(Long id , String name , Long created_by ,Long status , Long assigned_to 
    , Date created_at , Date finished_at , String message 
    )
    {
        this.id=id;
        this.name=name;
        this.created_by=created_by;
        this.status=status;
        this.assigned_to=assigned_to;
        this.created_at=created_at;
        this.finished_at=finished_at;
        this.message=message;
    }
}
