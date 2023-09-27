package com.hotsummer.luvme.service;

import com.hotsummer.luvme.model.entity.UserTbl;
import com.hotsummer.luvme.repository.UserTblRepository;
import com.hotsummer.luvme.service.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import request.AuthenticationRequest;
import request.RegisterRequest;
import response.AuthenticationResponse;

@Service
@RequiredArgsConstructor
public class AuthenticateService {
    private final UserTblRepository repository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegisterRequest request){
        var user = UserTbl.builder()
                .email(request.getEmail())
                .build();
        repository.save(user);
        var jwtToken = jwtService.generateTokenForEntity(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        null
                )
        );
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateTokenForEntity(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
