package com.hotsummer.luvme.controller.api.exception;

import com.hotsummer.luvme.model.error.CustomError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.NativeWebRequest;
import org.zalando.problem.spring.web.advice.ProblemHandling;

@RestControllerAdvice
public class CustomProblemHandling implements ProblemHandling {

    @ExceptionHandler
    public ResponseEntity<CustomError> handleAuthenticationException (
            AuthenticationException e, NativeWebRequest request) {
        CustomError response = CustomError.builder()
                .errorCode("403")
                .message("Missing/Invalid/Expired id token")
                .build();
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
    }
}
