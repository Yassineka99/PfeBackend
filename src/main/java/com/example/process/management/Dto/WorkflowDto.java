package com.example.process.management.Dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WorkflowDto {
   public Long id ;
   public String name ;
   public Long created_by ;
   public Long product_id;
   public int status_id ;
   public int qty ;
   public String image;
   public String imageType;
   public WorkflowDto(){}
   
   public WorkflowDto(Long id , String name , Long created_by , Long product_id , int qty,int status_id,String image,String imageType)
   {
    this.id=id;
    this.name=name;
    this.created_by=created_by;
    this.product_id=product_id;
    this.qty=qty;
    this.status_id=status_id;
    this.image=image;
    this.imageType=imageType;
   } 
}
