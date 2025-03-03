package com.sansa.talentarena.model.dto;

import com.sansa.talentarena.model.enumerates.CaseType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewCaseReqDTO {
    private CaseType caseType;
}
