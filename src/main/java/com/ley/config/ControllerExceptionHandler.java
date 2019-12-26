package com.ley.config;

import com.ley.entity.ResponseObj;
import com.ley.exception.InvalidTokenException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResponseObj defaultErrorHandler(HttpServletRequest request, Exception e) throws Exception{
        System.out.println("defaultErrorHandler:" + e.toString());
        return ResponseObj.error(e);
    }

    @ResponseBody
    @ExceptionHandler(value = InvalidTokenException.class)
    public ResponseObj InvalidTokenExceptionHandler(HttpServletRequest request, InvalidTokenException e) throws Exception{
        System.out.println("InvalidTokenExceptionHandler");
        return ResponseObj.error(101, "invalid token");
    }
}
