package com.example.process.management.Mapper;

import com.example.process.management.Dto.ChatDto;
import com.example.process.management.Model.Chat;

public class ChatMapper {
    public ChatDto TODO (Chat chat)
    {
        if ( chat == null)
        {
            return null ;
        }
        ChatDto dto = new ChatDto() ;
        dto.setId(chat.getId());
        dto.setFrom_user(chat.getFrom_user());
        dto.setTo_user(chat.getTo_user());
        dto.setFrom_user_date(chat.getFrom_user_date());
        dto.setTo_user_date(chat.getTo_user_date());
        dto.setMessage(chat.getMessage());
        return dto ;
    }

    public Chat TOEntity (ChatDto chat)
    {
        if ( chat == null)
        {
            return null ;
        }
        Chat dto = new Chat() ;
        dto.setId(chat.getId());
        dto.setFrom_user(chat.getFrom_user());
        dto.setTo_user(chat.getTo_user());
        dto.setFrom_user_date(chat.getFrom_user_date());
        dto.setTo_user_date(chat.getTo_user_date());
        dto.setMessage(chat.getMessage());
        return dto ;
    }
}
