package com.example.process.management.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.process.management.Model.Notification;
import com.example.process.management.Service.NotificationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/notifications")
public class NotificationController
{
    @Autowired
    NotificationService notifService ;

    @GetMapping("/id/{id}")
    public Optional<Notification> getNotificationByID(@PathVariable Long id )
    {
        return notifService.getNotificationByID(id);
    }
    @GetMapping("/userid/{userid}")
    public List<Notification> getNotificationByUserID(@PathVariable Long userid )
    {
        return notifService.getNotificationByUserID(userid);
    }
    @PostMapping("/create")
    public ResponseEntity<Notification> CreateNotification(@RequestBody Notification entity) {
        //TODO: process POST request
        Notification notiToSave =notifService.SaveNotification(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(notiToSave);
    }
        @PostMapping("/read/{userId}")
        public ResponseEntity<String> markAllAsRead(@PathVariable Long userId) {
            notifService.ReadNotifications(userId);
        return ResponseEntity.ok("All notifications marked as read");
    }

    @GetMapping("/unread-notification/{userid}")
    public List<Notification> getUnreadNotification(@PathVariable Long userid )
    {
        return notifService.getNonReadNotifications(userid);
    }
    
        
}