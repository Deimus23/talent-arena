package com.sansa.talentarena.service;

import com.sansa.talentarena.model.entity.Case;
import com.sansa.talentarena.repository.CaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CaseService {

    private final CaseRepository caseRepository;

    public List<Case> findAllCases() {
        return (List<Case>) this.caseRepository.findAll();
    }
}
