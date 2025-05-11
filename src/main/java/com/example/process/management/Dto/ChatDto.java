package com.example.process.management.Dto;

import java.util.Date;

import lombok.Setter;
import lombok.Getter;
@Setter
@Getter

public class ChatDto {
    private Long id ;
    private String message ; 
    private Date from_user_date ;
    private Date to_user_date ;
    private Long from_user;
    private Long to_user ;
    public ChatDto()
    {

    }
    public ChatDto(Long id ,String message , Date from_user_date,Date to_user_date ,Long from_user , Long to_user )
    {
        this.id=id;
        this.message=message;
        this.from_user=from_user;
        this.from_user_date=from_user_date;
        this.to_user=to_user;
        this.to_user_date=to_user_date;
    }
    
}
