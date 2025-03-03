package com.sansa.talentarena.controller;

import com.sansa.talentarena.model.dto.AuthSuccessDTO;
import com.sansa.talentarena.model.dto.LoginRequestDTO;
import com.sansa.talentarena.model.dto.RegisterRequestDTO;
import com.sansa.talentarena.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@RequiredArgsConstructor
@CrossOrigin(allowedHeaders = "*", originPatterns = "*")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/auth/register")
    public AuthSuccessDTO registerUser(@RequestBody RegisterRequestDTO requestDTO) {
        String token = this.authService.registerUser(requestDTO);
        return new AuthSuccessDTO(token);
    }
    @PostMapping("/auth/login")
    public AuthSuccessDTO loginUser(@RequestBody LoginRequestDTO loginRequestDTO){
        String token = this.authService.loginUser(loginRequestDTO);
        return new AuthSuccessDTO(token);
    }
}
