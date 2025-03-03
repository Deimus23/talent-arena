package com.sansa.talentarena.controller;

import com.sansa.talentarena.model.dto.CaseDTO;
import com.sansa.talentarena.model.dto.NewCaseReqDTO;
import com.sansa.talentarena.model.entity.Case;
import com.sansa.talentarena.model.enumerates.CaseType;
import com.sansa.talentarena.service.CaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@CrossOrigin(allowedHeaders = "*", originPatterns = "*")
@RequestMapping("/cases")
public class CaseController {

    private final CaseService caseService;

    @GetMapping
    public List<CaseDTO> getAllCases() {
        return this.caseService.findAllCases();
    }

    @PostMapping CaseDTO createCase(@RequestBody NewCaseReqDTO req) {
        return this.caseService.createCase(req.getCaseType());
    }

    @GetMapping("/{caseId}")
    CaseDTO getCaseById(@PathVariable UUID caseId) {
        return this.caseService.findCaseById(caseId);
    }

}
