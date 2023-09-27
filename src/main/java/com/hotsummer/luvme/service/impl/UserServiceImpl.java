package com.hotsummer.luvme.service.impl;

import java.util.Optional;

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
