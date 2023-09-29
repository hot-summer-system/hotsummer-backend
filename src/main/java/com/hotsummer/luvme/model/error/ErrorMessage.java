package com.hotsummer.luvme.model.error;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ErrorMessage {
    private int statusCode;
    private String message;
}
