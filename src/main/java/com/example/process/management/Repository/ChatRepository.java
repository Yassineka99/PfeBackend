package com.example.process.management.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.process.management.Model.Chat;
import com.example.process.management.Model.User;

public interface ChatRepository extends JpaRepository<Chat,Long> {

        @Query("SELECT c FROM Chat c WHERE c.from_user= :id")
        List<Chat> findMessageBySender(@Param("id") Long id);

        @Query("SELECT c FROM Chat c WHERE c.to_user= :id")
        List<Chat> findMessageByReciever(@Param("id") Long id);

        @Query("SELECT c FROM Chat c WHERE c.from_user= :id AND c.to_user= :id2")
        List<Chat> findMessageBySenderAndReciever(@Param("id") Long id,@Param("id2") Long id2);
} 
