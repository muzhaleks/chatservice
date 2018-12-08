package com.infopulse.advice;

import com.infopulse.dto.ErrorInfo;
import com.infopulse.exception.AlreadyExistException;
import com.infopulse.exception.MessageException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({AlreadyExistException.class})
    @ResponseBody
    public ErrorInfo handle(HttpServletRequest request, Exception exception){
        return new ErrorInfo().setMessage(exception.getMessage())
                              .setDeveloperMessage(exception.toString())
                              .setUri(request.getRequestURI());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({MessageException.class})
    @ResponseBody
    public ErrorInfo handleMessage(HttpServletRequest request, MessageException exception){
        return new ErrorInfo().setMessage(exception.getMessage())
                .setDeveloperMessage(exception.toString())
                .setUri(request.getRequestURI());
    }

}
