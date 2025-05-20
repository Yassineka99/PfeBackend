package com.example.process.management.Dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class ProductDto {
    public Long id ;
    public  String name;
    public int status_id;
    public MultipartFile modelFile;
    public String modelFileName ;
    public String modelFileType ;
    public ProductDto(){};
    public ProductDto(Long id , String name , int status_id, MultipartFile modFile , String modelFileName ,String modelFileType
    ){
        this.id=id;
        this.modelFile=modFile;
        this.name=name;
        this.status_id=status_id;
        this.modelFileName=modelFileName;
        this.modelFileType=modelFileType;
    };


}
