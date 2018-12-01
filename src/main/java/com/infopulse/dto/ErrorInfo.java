package com.infopulse.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class ErrorInfo {
    String message;
    String developerMessage;
    String uri;
}