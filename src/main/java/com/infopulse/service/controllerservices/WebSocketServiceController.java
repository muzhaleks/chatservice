package com.infopulse.service.controllerservices;

import com.infopulse.converter.MessageConverter;
import com.infopulse.dto.SendMessage;
import com.infopulse.entity.Message;
import com.infopulse.entity.RedisMessage;
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
       List<Message> messages = messageService.getAllPrivateMessages(sender);
       List<SendMessage> privateMessages = messageConverter.convertListPrivateMessagesToSendMessages(messages);
       List<RedisMessage> broadcastMessages = messageService.getAllBroadCastMessages();
       List<SendMessage> broadMessages = messageConverter.convertListBroadcastMessagesToSendMessages(broadcastMessages);
       privateMessages.addAll(broadMessages);
       return privateMessages;
    }

    public void deleteAllPrivateMessages(String receiver){
        messageService.deleteAllPrivateMessages(receiver);
    }

    public void saveBroadcastMessage(SendMessage sendMessage){
        messageService.saveBroadcastMessage(sendMessage.getSender(), sendMessage.getMessage());
    }

    public void savePrivateMessage(String to, SendMessage sendMessage){
        messageService.savePrivateMessage(to, sendMessage.getSender(), sendMessage.getMessage());
    }
}
