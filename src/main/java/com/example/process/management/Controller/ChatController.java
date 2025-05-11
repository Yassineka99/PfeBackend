package com.example.process.management.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.process.management.Model.Chat;
import com.example.process.management.Model.User;
import com.example.process.management.Service.ChatService;

@RestController
@RequestMapping("api/chat")
public class ChatController {
    @Autowired
    ChatService chatService ;

    @PostMapping("/create")
    public ResponseEntity<Chat> CreateUser(@RequestBody Chat chat) {
        Chat savedchat= chatService.CreateMessage(chat);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedchat);
    }

    @PostMapping("/update")
    public ResponseEntity <Chat> UpdateUser(@RequestBody Chat chat){
        Chat updatedchat = chatService.UpdateMessage(chat);
        return ResponseEntity.status(HttpStatus.OK).body(updatedchat);
    }

    @GetMapping("/get-all-by-sender-id/{id}")
    public List<Chat> GetAllbySenderid(@PathVariable Long id){
        return chatService.getMessagesBySender(id);
    }


    @GetMapping("/get-all-by-reciever-id/{id}")
    public List<Chat> GetAllbyRecieverid(@PathVariable Long id){
        return chatService.getMessagesByReciever(id);
    }
}
