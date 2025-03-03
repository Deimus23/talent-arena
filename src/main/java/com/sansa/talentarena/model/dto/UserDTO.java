package com.sansa.talentarena.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private UUID id;
    private String name;
    private String email;
    private String phone;
    private String dni;
    private String bloodType;
    private String knownIssues;
    private String healthCardNumber;
}
