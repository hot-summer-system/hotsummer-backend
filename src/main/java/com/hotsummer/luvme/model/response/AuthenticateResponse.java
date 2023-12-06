package com.hotsummer.luvme.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AuthenticateResponse {
    private Integer userId;
    private String status;
    private Boolean isTest;
    private String email;
    private Boolean isPremium;
}
