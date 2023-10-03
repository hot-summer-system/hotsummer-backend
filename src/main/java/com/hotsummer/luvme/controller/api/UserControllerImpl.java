package com.hotsummer.luvme.controller.api;

import com.hotsummer.luvme.controller.UserController;
import com.hotsummer.luvme.controller.api.exception.CustomBadRequestException;
import com.hotsummer.luvme.controller.api.exception.CustomForbiddenException;
import com.hotsummer.luvme.model.entity.UserTbl;
import com.hotsummer.luvme.model.error.CustomError;
import com.hotsummer.luvme.model.mapper.ObjectMapper;
import com.hotsummer.luvme.model.request.UserRequest;
import com.hotsummer.luvme.model.response.UserResponse;
import com.hotsummer.luvme.service.impl.UserServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "User Setting API")
public class UserControllerImpl implements UserController {
    private final UserServiceImpl userService;
    @Override
    public ResponseEntity<UserResponse> updateUserWithNonFullFill(Integer userId, UserRequest userRequest) throws CustomBadRequestException, CustomForbiddenException {
        if(userRequest == null){
            throw new CustomBadRequestException(
                    CustomError.builder().errorCode("400").errorCode("User Request Is Null").build());
        }
        UserResponse response = ObjectMapper.fromUserTblToUserResponse(userService.updateUserWithNonFullFill(userId, userRequest));
        return ResponseEntity.ok(response);
    }
}
