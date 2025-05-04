package com.example.process.management.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.process.management.Model.Notification;
import com.example.process.management.Model.User;

@Repository
public interface NotificationRepository extends JpaRepository<Notification,Long>{
       @Query("SELECT c FROM Notification c WHERE c.user_to_notify= :userid")
        List<Notification> findByUserToNotify(@Param("userid") Long userid);
        @Query("SELECT c FROM Notification c WHERE c.user_to_notify = :userid AND c.visiblity = 0")
        List<Notification> findUnreadNotificationsByUserId(@Param("userid") Long userid);
        
        
}
