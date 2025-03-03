package com.sansa.talentarena.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class LoginRequestDTO {
    private String email;
    private String password;
}
