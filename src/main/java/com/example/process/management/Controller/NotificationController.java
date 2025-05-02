package com.example.process.management.Controller;

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
    @GetMapping("/id/{userid}")
    public ResponseEntity<Notification> getNotificationByUserID(@PathVariable Long id )
    {
        Notification notif = notifService.getNotificationByUserID(id);
        if (notif !=null)
        {
             return ResponseEntity.status(HttpStatus.OK).body(notif);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(notif);
        }
    }    
}