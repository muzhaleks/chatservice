package com.infopulse.controller;

import com.infopulse.dto.ReceiveMessage;
import com.infopulse.dto.SendMessage;
import com.infopulse.service.controllerservices.WebSocketServiceController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class WebSocketController {

    @Autowired
    private WebSocketServiceController webSocketService;

    @MessageMapping("/hello/connect")
    @SendTo("/topic/messages")
    public List<SendMessage> handleMessage(Message message) throws Exception {
        ReceiveMessage receiveMessage = (ReceiveMessage)message.getPayload();
        MessageHeaders messageHeader = message.getHeaders();
        String sender = (String)messageHeader.get("sender");
        return webSocketService.getAllMessage(sender);
    }
}
