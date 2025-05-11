package com.example.process.management.Service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.process.management.Model.Chat;
import com.example.process.management.Repository.ChatRepository;


@Service
public class ChatService {
    @Autowired
    ChatRepository chatrepo ;

    public List<Chat> getMessagesBySender(Long id)
    {
        return chatrepo.findMessageBySender(id);
    }
    public List<Chat> getMessagesByReciever(Long id)
    {
        return chatrepo.findMessageByReciever(id);
    }

    public Chat CreateMessage (Chat chat)
    {   
        chat.setFrom_user_date(new Date());
       return chatrepo.save(chat);
    }

    public Chat UpdateMessage (Chat chat)
    {
        Chat currentchat = chatrepo.findById(chat.getId()).orElse(null);
        if(chat.getMessage()!=null)
        currentchat.setMessage(chat.getMessage());
        if(chat.getFrom_user()!=null)
        currentchat.setFrom_user(chat.getFrom_user());
        if(chat.getFrom_user_date()!=null)
        currentchat.setFrom_user_date(chat.getFrom_user_date());
        if(chat.getTo_user()!=null)
        currentchat.setTo_user(chat.getTo_user());
        if(chat.getTo_user_date()!= null)
        currentchat.setTo_user_date(chat.getTo_user_date());
        return chatrepo.save(currentchat);
    }

}
