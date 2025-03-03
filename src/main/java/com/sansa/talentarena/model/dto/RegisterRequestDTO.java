package com.sansa.talentarena.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class RegisterRequestDTO {
    private String name;
    private String email;
    private String password;
    private String dni;
    private String phone;
    private String healthCareNumber;
    private String bloodType;
    private String knownIssues;
}
