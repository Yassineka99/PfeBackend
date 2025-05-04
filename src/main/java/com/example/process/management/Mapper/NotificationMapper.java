package com.example.process.management.Mapper;

import com.example.process.management.Dto.NotificationDto;
import com.example.process.management.Model.Notification;

public class NotificationMapper {
    public NotificationDto NotificationToNotificationDto (Notification notif )
    {
        if ( notif == null)
        {
            return null ;
        }
        NotificationDto noDto= new NotificationDto();
        noDto.setId(notif.getId());
        noDto.setUser_to_notify(notif.getUser_to_notify());
        noDto.setMessage(notif.getMessage());
        noDto.setVisiblity(notif.getVisiblity());
        return noDto;

    }
    public Notification NotificationDtoToNotification(NotificationDto dto)
    {
        if(dto == null)
        {
            return null ;
        }
        Notification notif = new Notification();
        notif.setId(dto.getId());
        notif.setMessage(dto.getMessage());
        notif.setUser_to_notify(dto.getUser_to_notify());
        notif.setVisiblity(dto.getVisiblity());
        return notif ;
    }
}

