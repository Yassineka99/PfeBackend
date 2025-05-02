package com.example.process.management.Dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WorkflowDto {
   public Long id ;
   public String name ;
   public Long created_by ;
   public WorkflowDto(){}
   
   public WorkflowDto(Long id , String name , Long created_by)
   {
    this.id=id;
    this.name=name;
    this.created_by=created_by;
   } 
}
