package com.hotsummer.luvme.service.impl;

import com.hotsummer.luvme.controller.api.exception.CustomInternalServerException;
import com.hotsummer.luvme.model.entity.Routing;
import com.hotsummer.luvme.model.entity.RoutingProduct;
import com.hotsummer.luvme.model.error.CustomError;
import com.hotsummer.luvme.model.request.RoutingProductRequest;
import com.hotsummer.luvme.repository.RoutingProductRepository;
import com.hotsummer.luvme.service.RoutingProductService;
import lombok.RequiredArgsConstructor;
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
        List<RoutingProduct> routingProducts = routing.getRoutingProducts();
        if(routingProducts == null || routingProducts.stream().count() == 0){
            SaveRoutingProduct(routingProductRequests, routing);
            return true;
        }
        for(RoutingProduct rp : routingProducts){
            routingProductRepository.delete(rp);
        }
        SaveRoutingProduct(routingProductRequests, routing);
        return true;
    }

    private void SaveRoutingProduct(List<RoutingProductRequest> routingProductRequests, Routing routing) throws CustomInternalServerException {
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
    }
}
