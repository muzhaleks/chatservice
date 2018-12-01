package com.infopulse.controller;

import com.infopulse.dto.ChatUserDto;
import com.infopulse.service.controllerservices.ChatUserControllerService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ChatUserController {

    private ChatUserControllerService chatUserControllerService;

    public ChatUserController(ChatUserControllerService chatUserControllerService)
    {
        this.chatUserControllerService = chatUserControllerService;
    }

    @RequestMapping(value="/registration", method = RequestMethod.POST)
    public void saveUser(@Valid @RequestBody ChatUserDto chatUserDto){

        chatUserControllerService.saveChatUser(chatUserDto);
    }
}
