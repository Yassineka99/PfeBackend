package com.example.process.management.Dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProcessDto {
    public Long id ;
    public String name ;
    public Long workflow_id;
    public Long status_id;
    public int order ;
    public Date created_at;
    public Date finished_at;
    public Long created_by ;
    public Date updated_at;
    public Long updated_by;
    public ProcessDto(){}
    public ProcessDto(Long id , String name , Long workflow_id, 
    Long status_id , int order , Date created_at , 
    Date finished_at , Long created_by , Date updated_at ,Long updated_by )
    {
        this.id=id ;
        this.name=name;
        this.workflow_id=workflow_id;
        this.status_id=status_id;
        this.order=order;
        this.created_at=created_at;
        this.finished_at=finished_at;
        this.created_by=created_by;
        this.updated_at=updated_at;
        this.updated_by=updated_by;
    }
}
