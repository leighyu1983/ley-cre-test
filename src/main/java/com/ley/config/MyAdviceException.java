package com.ley.config;

import com.ley.entity.ResponseObj;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class MyAdviceException {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResponseObj exceptionHandler(Exception ex) {
        return ResponseObj.error(ex);
    }

    /*
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> runtimeErrorHandler(RuntimeException ex) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ResponseObj.error(null));
    }*/
}
