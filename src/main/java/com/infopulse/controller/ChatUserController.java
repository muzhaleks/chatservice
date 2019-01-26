package com.infopulse.controller;

import com.infopulse.dto.ChatUserDto;
import com.infopulse.service.controllerservices.ChatUserControllerService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ChatUserController {

    private ChatUserControllerService chatUserControllerService;

    public ChatUserController(ChatUserControllerService chatUserControllerService)
    {
        this.chatUserControllerService = chatUserControllerService;
    }

    @CrossOrigin
    @RequestMapping(value="/registration", method = RequestMethod.POST)
    public void saveUser(@Valid @RequestBody ChatUserDto chatUserDto){

        chatUserControllerService.saveChatUser(chatUserDto);
    }

    @RequestMapping(value="/users", method=RequestMethod.GET)
    public List<ChatUserDto> getAllUsersExceptAdmins(){
        return chatUserControllerService.getAllUsers();
    }
}
