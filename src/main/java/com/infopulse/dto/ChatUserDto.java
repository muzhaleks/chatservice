package com.infopulse.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ChatUserDto {

    @NotNull(message = "Name is required")
    private String name;

    @NotNull(message = "Login is required")
    private String login;

    @NotNull(message = "Password is required")
    private String password;

    private Boolean isBanned;

}
