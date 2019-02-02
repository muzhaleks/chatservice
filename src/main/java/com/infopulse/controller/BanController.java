package com.infopulse.controller;

import com.infopulse.dto.ChatUserDto;
import com.infopulse.service.controllerservices.BanControllerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class BanController {

    @Autowired
    private BanControllerService banControllerService;

    @RequestMapping(value="/ban", method = RequestMethod.POST)
    public void addUserToBan(@RequestBody ChatUserDto chatUserDto){
        banControllerService.addUserToBan(chatUserDto);
    }

    @RequestMapping(value="/ban/{login}", method = RequestMethod.DELETE)
    public void removeUserFromBan(@PathVariable("login") String login){
       banControllerService.removeUserFromBan(login);
    }

}
