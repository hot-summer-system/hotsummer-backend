package com.hotsummer.luvme.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotsummer.luvme.model.response.AuthenticateResponse;
import com.hotsummer.luvme.service.Authentication.AuthenticationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Tag(name = "Authenticate API")
public class AuthenticationController {
    private final AuthenticationService authenticateService;

    // @PostMapping("/register")
    // public ResponseEntity<AuthenticationResponse> register(
    // @RequestBody RegisterRequest request
    // ){
    // return ResponseEntity.ok(authenticateService.register(request));
    // }
    @Operation(summary = "Login with google firebase", description = "put token into header for authenticate")
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticateResponse> authenticate() {
        AuthenticateResponse authenticateResponse = authenticateService.authenticateUser();
        return ResponseEntity.ok(authenticateResponse);
    }
}
