package com.sansa.talentarena.controller;

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
    public String registerUser(@RequestBody RegisterRequestDTO requestDTO) {
        return this.authService.registerUser(requestDTO);
    }
    @PostMapping("/auth/login")
    public String loginUser(@RequestBody LoginRequestDTO loginRequestDTO){
        return  this.authService.loginUser(loginRequestDTO);
    }
}
