package com.infopulse.service.dataservice;

import com.infopulse.entity.ChatUser;
import com.infopulse.entity.Message;
import com.infopulse.entity.RedisMessage;
import com.infopulse.repository.ChatUserRepository;
import com.infopulse.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private ChatUserRepository chatUserRepository;

    @Autowired
    private RedisTemplate<String, RedisMessage> redisMessageRepository;

    public List<Message> getAllPrivateMessages(String sender) {
        return messageRepository.findByReceiver_Login(sender);
    }

    @Transactional
    public void savePrivateMessage(String to, String from, String message){
        ChatUser receiver = chatUserRepository.findByLogin(to);
        ChatUser sender =chatUserRepository.findByLogin(from);
        Message mess = new Message();
        mess.setBody(message);
        mess.setReceiver(receiver);
        mess.setSender(sender);
        messageRepository.save(mess);

    }

    @Transactional
    public void deleteAllPrivateMessages(String receiver){

        messageRepository.deleteByReceiver_Login(receiver);
    }

    public void saveBroadcastMessage(String sender, String message){
        RedisMessage redisMessage = new RedisMessage();
        redisMessage.setSender(sender);
        redisMessage.setMessage(message);
        redisMessageRepository.opsForList().leftPush("broadcast", redisMessage);
    }

    public List<RedisMessage> getAllBroadCastMessages(){
        return  redisMessageRepository
                .opsForList()
                .range("broadcast", 0, -1);
    }

}