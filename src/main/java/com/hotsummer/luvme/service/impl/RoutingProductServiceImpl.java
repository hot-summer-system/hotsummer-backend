package com.hotsummer.luvme.service.impl;

import com.hotsummer.luvme.controller.api.exception.CustomInternalServerException;
import com.hotsummer.luvme.model.entity.Routing;
import com.hotsummer.luvme.model.entity.RoutingProduct;
import com.hotsummer.luvme.model.error.CustomError;
import com.hotsummer.luvme.model.request.RoutingProductRequest;
import com.hotsummer.luvme.repository.RoutingProductRepository;
import com.hotsummer.luvme.service.RoutingProductService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.slf4j.ILoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class RoutingProductServiceImpl implements RoutingProductService {
    private final RoutingProductRepository routingProductRepository;

    @Override
    public Boolean CreateRoutingProduct(List<RoutingProductRequest> routingProductRequests, Routing routing) throws CustomInternalServerException {
        for(RoutingProductRequest r : routingProductRequests){
            RoutingProduct routingStep = RoutingProduct.builder()
                    .productId(r.getProductId().toString())
                    .orderProduct(r.getOrderProduct())
                    .routing(routing)
                    .build();
            if(routingProductRepository.save(routingStep) == null){
                throw new CustomInternalServerException(CustomError.builder().errorCode("500").message("Saving Routing Product Failed").build());
            }
        }
        return true;
    }
}
