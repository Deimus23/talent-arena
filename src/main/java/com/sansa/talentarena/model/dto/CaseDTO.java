package com.sansa.talentarena.model.dto;

import com.sansa.talentarena.model.enumerates.CaseType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CaseDTO {
    private UUID id;
    private UserDTO user;
    private String coordinates;
    private int reliability;
    private CaseType caseType;
    private boolean priorized;
    private LocalDateTime timestamp;
}
