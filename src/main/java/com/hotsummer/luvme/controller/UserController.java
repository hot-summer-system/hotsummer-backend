package com.hotsummer.luvme.controller;

import com.hotsummer.luvme.controller.api.exception.CustomBadRequestException;
import com.hotsummer.luvme.controller.api.exception.CustomForbiddenException;
import com.hotsummer.luvme.model.request.UserRequest;
import com.hotsummer.luvme.model.response.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("api/v1/user")
public interface UserController {
    @Operation(summary = "Update User Fill", description = "Update All Fill That User Input")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get Question Success"),
            @ApiResponse(responseCode = "400", description = "Some Fill Input Incorrect"),
            @ApiResponse(responseCode = "401", description = "User Not Allow To Do This Function"),
            @ApiResponse(responseCode = "404", description = "Error Occur With User"),
            @ApiResponse(responseCode = "500", description = "Server Error"),
    })
    @PutMapping("/updateFill/{userId}")
    @PreAuthorize("hasAuthority('CUSTOMER')")
    public ResponseEntity<UserResponse> updateUserWithNonFullFill(@PathVariable("userId") Integer userId, UserRequest userRequest)
            throws CustomBadRequestException, CustomForbiddenException;
}
