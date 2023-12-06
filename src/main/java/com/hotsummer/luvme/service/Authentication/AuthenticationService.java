package com.hotsummer.luvme.service.Authentication;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.hotsummer.luvme.model.entity.UserTbl;
import com.hotsummer.luvme.model.enums.UserStatus;
import com.hotsummer.luvme.model.response.AuthenticateResponse;
import com.hotsummer.luvme.security.UserDetailsImpl;

@Service
public class AuthenticationService {
    public static UserTbl getCurrentUserFromSecurityContext() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof UserDetails) {
                return ((UserDetailsImpl) principal).getUserTbl();
            }
        }
        return null;
    }

    public static boolean checkCurrentUser() {
        UserTbl user = getCurrentUserFromSecurityContext();
        return user.getStatus().equals(UserStatus.ACTIVE.toString());
    }

    public AuthenticateResponse authenticateUser() {
        UserTbl user = getCurrentUserFromSecurityContext();
        return new AuthenticateResponse(
                user.getUserId(),
                user.getStatus(),
                user.getIsTest(),
                user.getEmail(),
                user.getIsPremium());

    }
}
