package com.hotsummer.luvme.service.impl;

import com.hotsummer.luvme.controller.api.exception.CustomInternalServerException;
import com.hotsummer.luvme.controller.api.exception.CustomNotFoundException;
import com.hotsummer.luvme.model.entity.Product;
import com.hotsummer.luvme.model.entity.Routing;
import com.hotsummer.luvme.model.entity.RoutingProduct;
import com.hotsummer.luvme.model.error.CustomError;
import com.hotsummer.luvme.model.mapper.ObjectMapper;
import com.hotsummer.luvme.model.mapper.TimeConverter;
import com.hotsummer.luvme.model.response.RoutingResponse;
import com.hotsummer.luvme.repository.ProductRepository;
import com.hotsummer.luvme.repository.RoutingRepository;
import com.hotsummer.luvme.service.Authentication.AuthenticationService;
import com.hotsummer.luvme.service.RoutingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class RoutingServiceImpl implements RoutingService {
    private final RoutingRepository routingRepository;
    private final ProductRepository productRepository;
    @Override
    public Routing ModifyRoutine(String description, String dateReminder) throws CustomInternalServerException {
        Routing oldRouting = routingRepository.findFirstByUserActUserIdOrderByDateDesc(
                AuthenticationService.getCurrentUserFromSecurityContext().getUserId());

        if(oldRouting != null){
            oldRouting.setDescription(description);
            oldRouting.setDate(TimeConverter.getCurrentDate());
            oldRouting.setRoutingType(dateReminder.contains("AM") ? "MORNING" : "NIGHT");
            oldRouting.setDateReminder(TimeConverter.getCronExpression(dateReminder));
            if(routingRepository.save(oldRouting) == null){
                throw new CustomInternalServerException(CustomError.builder().errorCode("500").message("Update Failed").field("Modify Routing").build());
            }
            return oldRouting;
        }
        Routing routing = Routing.builder()
                .routing_id(UUID.randomUUID())
                .routingType(dateReminder.contains("AM") ? "MORNING" : "NIGHT")
                .date(TimeConverter.getCurrentDate())
                .description(description)
                .dateReminder(TimeConverter.getCronExpression(dateReminder))
                .userAct(AuthenticationService.getCurrentUserFromSecurityContext())
                .isDone(false)
                .build();
        if(routingRepository.save(routing) == null){
            throw new CustomInternalServerException(CustomError.builder().errorCode("500").message("Create Failed").field("Modify Routing").build());
        }
        return routing;
    }

    @Override
    public Boolean CreateRoutingScheduling(int userId) throws CustomInternalServerException {
          Routing routing = routingRepository.findFirstByUserActUserIdOrderByDateDesc(userId);

          Routing newRouting = Routing.builder()
                  .routing_id(UUID.randomUUID())
                  .routingType(routing.getRoutingType())
                  .date(TimeConverter.getCurrentDate())
                  .description(routing.getDescription())
                  .dateReminder(routing.getDateReminder())
                  .routingProducts(routing.getRoutingProducts())
                  .userAct(routing.getUserAct())
                  .isDone(false)
                  .build();
          try{
              routingRepository.save(newRouting);
          }catch (Exception e){
             throw new CustomInternalServerException(CustomError.builder()
                     .errorCode("500").message(e.getMessage()).field("Create routing scheduling").build());
          }
          return true;
    }

    @Override
    public Boolean FinishedRouting(int userId) throws CustomInternalServerException {
        Routing routing = routingRepository.findFirstByUserActUserIdOrderByDateDesc(userId);
        try{
            routing.setIsDone(true);
            routingRepository.save(routing);
        }catch (Exception e){
            throw new CustomInternalServerException(CustomError.builder()
                    .errorCode("500").message(e.getMessage()).field("Finished routing").build());
        }
        return true;
    }

    @Override
    public RoutingResponse GetRouting(int userId) throws CustomNotFoundException {
        Routing routing = routingRepository.findFirstByUserActUserIdOrderByDateDesc(userId);
        List<Product> products = new ArrayList<>();
        if(routing == null){
            throw new CustomNotFoundException(CustomError.builder().errorCode("404").message("No routing found").build());
        }
        for (RoutingProduct routingProduct : routing.getRoutingProducts()) {
            products.add(productRepository.findByProductId(UUID.fromString(routingProduct.getProductId())));
        }
        return ObjectMapper.fromRoutingToRoutingResponse(routing, products);
    }

}
