package com.example.process.management.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.process.management.Model.Notification;
import com.example.process.management.Model.User;
import com.example.process.management.Repository.NotificationRepository;

@Service
public class NotificationService {
    @Autowired
    NotificationRepository notifRepo ;

    public Optional<Notification> getNotificationByID(Long id)
    {
         return notifRepo.findById(id);
    }
    public Notification getNotificationByUserID(Long id)
    {
         return notifRepo.findByUserToNotify(id);
    }
    public Notification SaveNotification(Notification notification)
    {
          return notifRepo.save(notification);
    }

}
