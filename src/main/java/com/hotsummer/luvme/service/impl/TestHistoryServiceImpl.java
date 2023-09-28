package com.hotsummer.luvme.service.impl;

import com.hotsummer.luvme.controller.api.exception.CustomBadRequestException;
import com.hotsummer.luvme.model.entity.TestHistory;
import com.hotsummer.luvme.model.entity.UserTbl;
import com.hotsummer.luvme.model.error.CustomError;
import com.hotsummer.luvme.repository.TestHistoryRepository;
import com.hotsummer.luvme.service.Authentication.AuthenticationService;
import com.hotsummer.luvme.service.TestHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Service
@RequiredArgsConstructor
@Transactional
public class TestHistoryServiceImpl implements TestHistoryService {
    private final TestHistoryRepository testHistoryRepository;

    @Override
    public TestHistory createNewTestHistory(String skinType) throws CustomBadRequestException {
        if(skinType == null){
            throw new CustomBadRequestException(
                    CustomError.builder().message("Skin Type Is Null").field("Skin Type").errorCode("400").build());
        }
        UserTbl userTbl = AuthenticationService.getCurrentUserFromSecurityContext();

        LocalDateTime currentDateTime = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(currentDateTime);

        TestHistory newTest = TestHistory.builder()
                .date(new Date(timestamp.getTime()))
                .skinType(skinType)
                .userAct(userTbl)
                .build();

        return testHistoryRepository.save(newTest);
    }
}
