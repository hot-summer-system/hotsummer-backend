package com.hotsummer.luvme.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotsummer.luvme.controller.api.exception.CustomBadRequestException;
import com.hotsummer.luvme.controller.api.exception.CustomNotFoundException;
import com.hotsummer.luvme.model.response.ResultResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RequestMapping("api/v1/result")
public interface ResultController {

    @Operation(summary = "Get Result By Id", description = "Get Result By Result Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get Result Success"),
            @ApiResponse(responseCode = "404", description = "Result Not Found"),
            @ApiResponse(responseCode = "400", description = "Result Save Failed"),
            @ApiResponse(responseCode = "500", description = "Server Error"),
    })
    @GetMapping("/{resultId}")
    @PreAuthorize("hasAuthority('CUSTOMER')")
    public ResultResponse getResultById(@PathVariable("resultId") Integer resultId)
            throws CustomNotFoundException, CustomBadRequestException;

}
