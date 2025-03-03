package com.sansa.talentarena.controller;

import com.sansa.talentarena.model.entity.Case;
import com.sansa.talentarena.service.CaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
