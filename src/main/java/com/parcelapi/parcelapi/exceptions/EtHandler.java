package com.parcelapi.parcelapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class EtHandler {
        @ExceptionHandler
        public ResponseEntity<Object> message(EtAuthException e){
         return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
}
