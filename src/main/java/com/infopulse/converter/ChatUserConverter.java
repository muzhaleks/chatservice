package com.infopulse.converter;

import com.infopulse.dto.ChatUserDto;
import com.infopulse.entity.ChatUser;

public class ChatUserConverter {

    public static ChatUser convertFromDto(ChatUserDto dto){
        ChatUser user = new ChatUser();
        user.setName(dto.getName());
        user.setLogin(dto.getLogin());
        return user;
    }

    public static ChatUserDto convertFromEntity(ChatUser user){
        ChatUserDto dto =  new ChatUserDto();
        dto.setLogin(user.getLogin());
        dto.setName(user.getName());
        return dto;
    }
}
