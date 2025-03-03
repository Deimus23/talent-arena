package com.sansa.talentarena.model.entity;

import com.sansa.talentarena.model.enumerates.CaseType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Case {

    @Id
    private UUID id;
    private String coordinates;
    private int reliability;
    private CaseType caseType;
    private boolean priorized;
    private LocalDateTime timestamp;

    @ManyToOne
    private User user;


}
