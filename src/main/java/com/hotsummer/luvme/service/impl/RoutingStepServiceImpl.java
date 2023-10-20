package com.hotsummer.luvme.service.impl;

import com.hotsummer.luvme.controller.api.exception.CustomInternalServerException;
import com.hotsummer.luvme.model.entity.RoutingStep;
import com.hotsummer.luvme.model.error.CustomError;
import com.hotsummer.luvme.repository.RoutingStepRepository;
import com.hotsummer.luvme.service.RoutingStepService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Service
@RequiredArgsConstructor
@Transactional
public class RoutingStepServiceImpl implements RoutingStepService {
    private final RoutingStepRepository routingStepRepository;
    @Override
    public List<RoutingStep> CreateRoutingStep(List<UUID> productId) throws CustomInternalServerException {
        List<RoutingStep> routingStepList = new ArrayList<>();
        for(UUID i : productId){
            RoutingStep routingStep = RoutingStep.builder()
                    .productId(i.toString())
                    .build();
            if(routingStepRepository.save(routingStep) == null){
                throw new CustomInternalServerException(CustomError.builder().errorCode("500").message("Create Routing Step Failed").build());
            }
            routingStepList.add(routingStep);
        }
        return routingStepList;
    }
}
