package com.infopulse.messaging;

import com.infopulse.dto.ChatUserDto;
import com.infopulse.exception.MessageException;
import com.infopulse.payload.EventEnum;
import com.infopulse.payload.Payload;
import org.apache.kafka.common.header.Headers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.binding.BinderAwareChannelResolver;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class EventPublisher {

    @Autowired
    private BinderAwareChannelResolver resolver;

    @EventListener
    public void publishObject(ChatUserDto chatUserDto){
        publish(chatUserDto);
    }

    private void publish(ChatUserDto chatUserDto){
        Payload payload =new Payload();
        payload.setSendObject(chatUserDto);
        payload.setEvent(EventEnum.INSERT.toString());

        Map<String, String> headers = new HashMap<>();
        headers.put("EventVersion", "v1");
        headers.put("EntityVersion", "v1");
        Message<Payload> message = MessageBuilder
                .withPayload(payload)
                .copyHeaders(headers)
                .build();

        MessageChannel channel = resolver.resolveDestination("user-event-output");
        if(!channel.send(message)){
            throw new MessageException("Message can not send to keycloak");
        }
    }
}
