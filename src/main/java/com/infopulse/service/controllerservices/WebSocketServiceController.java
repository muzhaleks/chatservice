package com.infopulse.service.controllerservices;

import com.infopulse.converter.MessageConverter;
import com.infopulse.dto.ReceiveMessage;
import com.infopulse.dto.SendMessage;
import com.infopulse.entity.Message;
import com.infopulse.service.dataservice.ChatUserDataService;
import com.infopulse.service.dataservice.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebSocketServiceController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private MessageConverter messageConverter;

    public List<SendMessage> getAllMessage(String sender){
       List<Message> messages = messageService.getAllMessages(sender);
       return messageConverter.toListDto(messages);
    }
}
