package com.hotsummer.luvme.controller;

import com.hotsummer.luvme.controller.api.exception.CustomBadRequestException;
import com.hotsummer.luvme.controller.api.exception.CustomInternalServerException;
import com.hotsummer.luvme.controller.api.exception.CustomNotFoundException;
import com.hotsummer.luvme.model.request.RoutingRequest;
import com.hotsummer.luvme.model.response.RoutingResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RequestMapping("api/v1/routing")
public interface RoutingController {
    @Operation(summary = "Update routing scheduling", description = "Update routing each user with setting time")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Task running Success"),
            @ApiResponse(responseCode = "500", description = "Error Occur"),
    })
    @PutMapping("/create/scheduling/{envKey}/{userId}")
    public ResponseEntity<String> CreateRoutingScheduling(@PathVariable("envKey") String evnKey, @PathVariable("userId") Integer userId)
            throws CustomBadRequestException, CustomInternalServerException;

    @Operation(summary = "Get routing", description = "Get routing with current user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get Success"),
            @ApiResponse(responseCode = "404", description = "No routing found"),
            @ApiResponse(responseCode = "500", description = "Error Occur"),
    })
    @GetMapping("/{userId}")
    public ResponseEntity<RoutingResponse> getRouting(@PathVariable("userId") Integer userId)
            throws CustomBadRequestException, CustomNotFoundException;


    @Operation(summary = "Update routing", description = "Update finished routing")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Task running Success"),
            @ApiResponse(responseCode = "500", description = "Error Occur"),
    })
    @PutMapping("/update/{userId}")
    public ResponseEntity<String> updateRouting(@PathVariable("userId") Integer userId)
            throws CustomBadRequestException, CustomInternalServerException;

    @Operation(summary = "Create Routing", description = "Create Routing And Routing Step")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Create Success"),
            @ApiResponse(responseCode = "400", description = "Some Fill Input Incorrect"),
            @ApiResponse(responseCode = "500", description = "Error Occur"),
    })
    @PostMapping("/create")
    @PreAuthorize("hasAuthority('CUSTOMER')")
    public ResponseEntity<String> createRouting(@RequestBody RoutingRequest request)
            throws CustomBadRequestException, CustomInternalServerException, ParseException;
}
