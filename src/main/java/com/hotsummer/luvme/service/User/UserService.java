package com.hotsummer.luvme.service.User;

import com.hotsummer.luvme.controller.api.exception.CustomBadRequestException;
import com.hotsummer.luvme.controller.api.exception.CustomForbiddenException;
import com.hotsummer.luvme.model.entity.UserTbl;
import com.hotsummer.luvme.model.request.UserRequest;

public interface UserService {
    UserTbl getUserByEmail(String email);
    UserTbl updateUserWithNonFullFill(int userId, UserRequest userRequest) throws CustomBadRequestException, CustomForbiddenException;
}
