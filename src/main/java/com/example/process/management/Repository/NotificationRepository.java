package com.example.process.management.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.process.management.Model.Notification;
import com.example.process.management.Model.User;

@Repository
public interface NotificationRepository extends JpaRepository<Notification,Long>{
       @Query("SELECT c FROM Notification c WHERE c.user_to_notify= :userid")
        Notification findByUserToNotify(@Param("userid") Long userid);
}
