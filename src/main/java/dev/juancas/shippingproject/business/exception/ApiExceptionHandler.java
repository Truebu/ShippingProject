package dev.juancas.shippingproject.business.exception;

import dev.juancas.shippingproject.model.dto.ApiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = ApiRequestException.class)
    public ResponseEntity<Object> handleObjectResponseException (ApiRequestException e){

        HttpStatus badRequest = HttpStatus.INTERNAL_SERVER_ERROR;

        ApiException apiException= new ApiException(e.getMessage(), badRequest, ZonedDateTime.now(ZoneId.of("Z")));
        //ApiException apiException= new ApiException(e.getMessage(), e, badRequest, ZonedDateTime.now(ZoneId.of("Z")));

        return new ResponseEntity<>(apiException, badRequest);
    }
}
