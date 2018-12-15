package com.infopulse.service.dataservice;

import com.infopulse.entity.Message;
import com.infopulse.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private RedisMessageRepository redisMessageRepository;

    public List<Message> getAllMessages(String sender) {
        List<Message> messagesJdbc = messageRepository.findByReceiver_Login(sender);
        List<Message> messagesRedis = redisMessageRepository.findAll();
        messagesJdbc.addAll(messagesRedis);
        return messagesJdbc;
    }
}