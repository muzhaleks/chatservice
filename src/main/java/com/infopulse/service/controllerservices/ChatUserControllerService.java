package com.infopulse.service.controllerservices;

import com.infopulse.converter.ChatUserConverter;
import com.infopulse.dto.ChatUserDto;
import com.infopulse.service.dataservice.ChatUserDataService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import javax.validation.Validator;
import java.util.List;

@Service
public class ChatUserControllerService {

    private ChatUserDataService chatUserDataService;
    private ApplicationEventPublisher applicationEventPublisher;

    public ChatUserControllerService(ChatUserDataService chatUserDataService,
                                     ApplicationEventPublisher publisher){

        this.chatUserDataService = chatUserDataService;
        this.applicationEventPublisher = publisher;
    }

    public void saveChatUser(ChatUserDto chatUserDto){
          ChatUserDto newChatUserDto = ChatUserConverter.convertFromEntity(
                  chatUserDataService.createUser(ChatUserConverter.convertFromDto(chatUserDto)));

          newChatUserDto.setPassword(chatUserDto.getPassword());

          applicationEventPublisher.publishEvent(newChatUserDto);


    }

    public List<ChatUserDto> getAllUsers(){
        return ChatUserConverter
                .convertToListDto(chatUserDataService.getAllUsers());
    }
}
