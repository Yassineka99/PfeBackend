package com.example.process.management.Service;

import java.util.List;
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
    public List<Notification> getNotificationByUserID(Long id)
    {
         return notifRepo.findByUserToNotify(id);
    }
    public Notification SaveNotification(Notification notification)
    {     notification.setVisiblity(0);
          return notifRepo.save(notification);
    }
    public void ReadNotifications(Long id)
    {
          List<Notification> allnotif = getNotificationByUserID(id);
          for (Notification notification : allnotif) {
               notification.setVisiblity(1);
               notifRepo.save(notification);
           }
          
    }
    public List<Notification> getNonReadNotifications(Long id)
    {
         return notifRepo.findUnreadNotificationsByUserId(id);
    }

}
