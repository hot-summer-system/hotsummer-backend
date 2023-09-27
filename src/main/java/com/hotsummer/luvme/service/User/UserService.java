package com.hotsummer.luvme.service.User;

import com.hotsummer.luvme.model.entity.UserTbl;

public interface UserService {
    UserTbl getUserByEmail(String email);
}
