package com.infopulse.converter;

import com.infopulse.dto.SendMessage;
import com.infopulse.entity.Message;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MessageConverter {

    public SendMessage convertToDto(Message message){
        SendMessage sendMessage =new SendMessage();
        sendMessage.setMessage(message.getBody());
        sendMessage.setSender(message.getSender().getLogin());
        return sendMessage;
    }

    public List<SendMessage> toListDto(List<Message> messages){
        return messages.stream()
                .map(entity -> convertToDto(entity))
                .collect(Collectors.toList());
    }

}
