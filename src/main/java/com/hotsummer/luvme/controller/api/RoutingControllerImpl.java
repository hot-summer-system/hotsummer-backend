package com.hotsummer.luvme.controller.api;

import com.hotsummer.luvme.controller.RoutingController;
import com.hotsummer.luvme.controller.api.exception.CustomBadRequestException;
import com.hotsummer.luvme.controller.api.exception.CustomInternalServerException;
import com.hotsummer.luvme.controller.api.exception.CustomNotFoundException;
import com.hotsummer.luvme.model.entity.Routing;
import com.hotsummer.luvme.model.error.CustomError;
import com.hotsummer.luvme.model.request.RoutingRequest;
import com.hotsummer.luvme.model.response.RoutingResponse;
import com.hotsummer.luvme.service.Authentication.AuthenticationService;
import com.hotsummer.luvme.service.impl.RoutingServiceImpl;
import com.hotsummer.luvme.service.impl.RoutingProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import java.text.ParseException;

@RestController
@RequiredArgsConstructor
public class RoutingControllerImpl implements RoutingController {
    @Value("${spring.scheduled.env-key}")
    private String envKey;

    private final RoutingServiceImpl routingService;
    private final RoutingProductServiceImpl routingStepService;

    @Override
    public ResponseEntity<String> CreateRoutingScheduling(String envKey, Integer userId) throws CustomBadRequestException, CustomInternalServerException {
        if(!envKey.equals(this.envKey)){
            throw new CustomBadRequestException(CustomError.builder()
                    .errorCode("400").message("Key not recognize").field("Env Key").build());
        }
        if(userId == null){
            throw new CustomBadRequestException(CustomError.builder()
                    .errorCode("400").message("User id not recognize").field("User Id").build());
        }
        if (routingService.CreateRoutingScheduling(userId)){
             return ResponseEntity.ok("Success");
        }
        return ResponseEntity.ok("Failed");
    }

    @Override
    public ResponseEntity<RoutingResponse> getRouting(Integer userId) throws CustomBadRequestException, CustomNotFoundException {
        if(userId == null){
            throw new CustomBadRequestException(CustomError.builder()
                    .errorCode("400").message("User id is null").field("User Id").build());
        }
        if(userId != AuthenticationService.getCurrentUserFromSecurityContext().getUserId()){
            throw new CustomBadRequestException(CustomError.builder()
                    .errorCode("400").message("User id not recognize").field("User Id").build());
        }
        RoutingResponse response = routingService.GetRouting(userId);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<String> finishedRouting(Integer userId) throws CustomBadRequestException, CustomInternalServerException {
        if(userId == null){
            throw new CustomBadRequestException(CustomError.builder()
                    .errorCode("400").message("User id is null").field("User Id").build());
        }
        if(userId != AuthenticationService.getCurrentUserFromSecurityContext().getUserId()){
            throw new CustomBadRequestException(CustomError.builder()
                    .errorCode("400").message("User id not recognize").field("User Id").build());
        }
        if (routingService.FinishedRouting(userId)){
            return ResponseEntity.ok("Routine Finished");
        }
        return ResponseEntity.ok("Failed Server Problem");
    }

    @Override
    public ResponseEntity<String> modifyRoutine(RoutingRequest request) throws CustomBadRequestException, CustomInternalServerException, ParseException {
        if(request == null){
            throw new CustomBadRequestException(CustomError.builder().errorCode("400").message("Request is null").build());
        }
        Routing routing = routingService.ModifyRoutine(request.getDescription(), request.getDateReminder());
        if(routing != null){
            if ( routingStepService.CreateRoutingProduct(request.getRoutingProductRequests(), routing)){
                return ResponseEntity.ok("Modify Success");
            }
        }
        return ResponseEntity.ok("Failed");
    }
}
