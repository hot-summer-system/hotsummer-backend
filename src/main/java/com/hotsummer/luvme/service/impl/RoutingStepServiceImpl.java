package com.hotsummer.luvme.service.impl;

import com.hotsummer.luvme.controller.api.exception.CustomInternalServerException;
import com.hotsummer.luvme.model.entity.Routing;
import com.hotsummer.luvme.model.entity.RoutingProduct;
import com.hotsummer.luvme.model.error.CustomError;
import com.hotsummer.luvme.model.request.RoutingProductRequest;
import com.hotsummer.luvme.repository.RoutingStepRepository;
import com.hotsummer.luvme.service.RoutingStepService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
@Service
@RequiredArgsConstructor
@Transactional
public class RoutingStepServiceImpl implements RoutingStepService {
    private final RoutingStepRepository routingStepRepository;
    @Override
    public Boolean CreateRoutingStep(List<RoutingProductRequest> routingProductRequests, Routing routing) throws CustomInternalServerException {
        for(RoutingProductRequest r : routingProductRequests){
            RoutingProduct routingStep = RoutingProduct.builder()
                    .productId(r.getProductId().toString())
                    .orderProduct(r.getOrderProduct())
                    .routing(routing)
                    .build();
            if(routingStepRepository.save(routingStep) == null){
                throw new CustomInternalServerException(CustomError.builder().errorCode("500").message("Create Routing Step Failed").build());
            }
        }
        return true;
    }
}
