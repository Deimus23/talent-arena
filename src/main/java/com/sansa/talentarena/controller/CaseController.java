package com.sansa.talentarena.controller;

import com.sansa.talentarena.model.dto.NewCaseReqDTO;
import com.sansa.talentarena.model.entity.Case;
import com.sansa.talentarena.model.enumerates.CaseType;
import com.sansa.talentarena.service.CaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cases")
public class CaseController {

    private final CaseService caseService;

    @GetMapping
    public List<Case> getAllCases() {
        return this.caseService.findAllCases();
    }

    @PostMapping Case createCase(@RequestBody NewCaseReqDTO req) {
        return this.caseService.createCase(req.getCaseType());
    }

}
