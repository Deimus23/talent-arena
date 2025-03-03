package com.sansa.talentarena.service;

import com.sansa.talentarena.model.dto.RegisterRequestDTO;
import com.sansa.talentarena.model.entity.User;
import com.sansa.talentarena.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTService jwtService;
    public String registerUser(RegisterRequestDTO requestDTO) {
        dniAutentification(requestDTO.getDni());
        User user = User.builder()
                .id(UUID.randomUUID())
                .email(requestDTO.getEmail())
                .name(requestDTO.getName())
                .dni(requestDTO.getDni())
                .healthCardNumber(requestDTO.getHealthCareNumber())
                .bloodType(requestDTO.getBloodType())
                .knownIssues(requestDTO.getKnownIssues())
                .password(passwordEncoder.encode(requestDTO.getPassword()))
                .build();

        User savedUser = userRepository.save(user);
        return jwtService.generateToken((UserDetails) savedUser, new HashMap<>());
    }
    public void dniAutentification(String dni){
        String LETTERS = "TRWAGMYFPDXBNJZSQVHLCKE";
        String dniRegex = "^[0-9]{8}[A-HJ-NP-TV-Z]$";

        if (!dni.matches(dniRegex)) {
          throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}
