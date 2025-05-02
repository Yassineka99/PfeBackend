package com.example.process.management.Dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class NotificationDto {
    private Long id ;
    private Long user_to_notify;
    private String message ;
    public NotificationDto(){}
    public NotificationDto(Long id , Long user_to_notify , String message)
    {
        this.id=id;
        this.user_to_notify=user_to_notify;
        this.message=message;
    }
}

