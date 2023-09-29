package com.hotsummer.luvme.model.error;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomError extends RuntimeException {

    private String errorCode;
    private String message;
    private String field;
    private String table;
}