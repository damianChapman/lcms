package com.directv.lcms.exception.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<IllegalArgumentException> handleGuestEntityException(IllegalArgumentException illegelArgumentException) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(illegelArgumentException, responseHeaders, httpStatus);
    }

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<HttpClientErrorException> handleGuestEntityException(HttpClientErrorException httpClientErrorException) {
        HttpStatus httpStatus = httpClientErrorException.getStatusCode();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(httpClientErrorException, responseHeaders, httpStatus);
    }

}
