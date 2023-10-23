package com.hotsummer.luvme.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Optional;
import java.util.TimeZone;

import com.hotsummer.luvme.controller.api.exception.CustomBadRequestException;
import com.hotsummer.luvme.controller.api.exception.CustomForbiddenException;
import com.hotsummer.luvme.model.enums.Gender;
import com.hotsummer.luvme.model.error.CustomError;
import com.hotsummer.luvme.model.request.UserRequest;
import com.hotsummer.luvme.service.Authentication.AuthenticationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hotsummer.luvme.model.entity.Role;
import com.hotsummer.luvme.model.entity.UserTbl;
import com.hotsummer.luvme.model.enums.RoleEnum;
import com.hotsummer.luvme.model.enums.UserStatus;
import com.hotsummer.luvme.repository.RoleRepositiory;
import com.hotsummer.luvme.repository.UserTblRepository;
import com.hotsummer.luvme.service.User.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {
    private final UserTblRepository userTblRepository;
    private final RoleRepositiory roleRepositiory;

    @Override
    public UserTbl getUserByEmail(String email) {
        Optional<UserTbl> isExistUser = userTblRepository.findByEmail(email);
        if (isExistUser.isPresent()) {
            return isExistUser.get();
        }
        return createNewUser(email);
    }

    @Override
    public UserTbl updateUserWithNonFullFill(int userId, UserRequest userRequest) throws CustomBadRequestException, CustomForbiddenException {
        UserTbl userTbl = AuthenticationService.getCurrentUserFromSecurityContext();
        if(userId != userTbl.getUserId()){
            throw new CustomForbiddenException(
                    CustomError.builder().
                            errorCode("403").message("User Un Recognize").field("User").build()
            );
        }
        if(!userTbl.getStatus().equals(UserStatus.NONFULLFILL.toString())){
            throw new CustomForbiddenException(
                    CustomError.builder().
                            errorCode("401").message("User Not Allow To Do This Function").field("User").build());
        }
        userTbl.setFullName(userRequest.getFullName());

        boolean isValidGender = false;
        for (Gender gender : Gender.values()) {
            if (gender.toString().equals(userRequest.getGender().toUpperCase())) {
                isValidGender = true;
                break;
            }
        }

        if(!isValidGender){
            throw new CustomBadRequestException(
                    CustomError.builder().errorCode("400").message("Incorrect input").field("Gender").build());
        }
        userTbl.setGender(userRequest.getGender());
        userTbl.setStatus(UserStatus.ACTIVE.toString());

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date parsedBirthDay;
        try {
            parsedBirthDay = dateFormat.parse( userRequest.getBirthDay().trim());
        } catch (ParseException e) {
            throw new CustomBadRequestException(
                    CustomError.builder().errorCode("400").message("Invalid date format").field("BirthDay").build());
        }

        userTbl.setBirthDay(parsedBirthDay);

        return userTblRepository.save(userTbl);
    }

    public UserTbl createNewUser(String email) {
        Role role = roleRepositiory.findByRoleName(RoleEnum.CUSTOMER.toString());
        UserTbl userTbl = new UserTbl();
        userTbl.setEmail(email);
        userTbl.setIsPremium(false);
        userTbl.setStatus(UserStatus.NONFULLFILL.toString());
        userTbl.setIsTest(false);
        userTbl.setRole(role);
        return userTblRepository.save(userTbl);
    }

}
