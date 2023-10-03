package com.hotsummer.luvme.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private int userId;
    private String email;
    private String fullName;
    private String gender;
    private String status;
    private Date birthDay;
    private String bankAccount;
    private Boolean isPremium;
    private Date startPremiumDate;
    private Date endPremiumDate;
    private boolean isTest;
}
