package com.infopulse.service.dataservice;

import com.infopulse.entity.ChatUser;
import com.infopulse.exception.AlreadyExistException;
import com.infopulse.repository.ChatUserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class ChatUserDataService {

    private ChatUserRepository chatUserRepository;

    public ChatUserDataService(ChatUserRepository chatUserRepository){
        this.chatUserRepository = chatUserRepository;
    }

    public ChatUser createUser(ChatUser chatUser){
        chatUser.setLastVisit(new Date());
        ChatUser dataBaseChatUser = chatUserRepository.findByLogin(chatUser.getLogin());
        if(dataBaseChatUser != null){

            throw new AlreadyExistException("Login already exists");

        }

        return chatUserRepository.save(chatUser);
    }
}
