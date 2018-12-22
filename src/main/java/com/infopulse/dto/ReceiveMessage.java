package com.infopulse.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
public class ReceiveMessage {
    @NotNull(message = "Name is required")
    private String type;

    @NotNull(message = "Name is required")
    private String message;
    private String receiver;
}
