package com.infopulse.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ReceiveMessage {
    private String message;
    private String receiver;
}
