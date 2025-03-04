package com.sansa.talentarena.service;

import com.sansa.talentarena.model.dto.CaseDTO;
import com.sansa.talentarena.model.entity.Case;
import com.sansa.talentarena.model.entity.User;
import com.sansa.talentarena.model.enumerates.CaseType;
import com.sansa.talentarena.repository.CaseRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CaseService {

    private final CaseRepository caseRepository;
    private final ModelMapper modelMapper;

    public List<CaseDTO> findAllCases() {
        List<Case> cases = (List<Case>)  this.caseRepository.findAll();
        return cases.stream().map(caseEnt -> modelMapper.map(caseEnt, CaseDTO.class)).toList();
    }

    public CaseDTO createCase(CaseType caseType) {
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Case newCase = new Case();
        newCase.setUser(currentUser);
        newCase.setCaseType(caseType);
        newCase.setId(UUID.randomUUID());
        newCase.setReliability(this.getReliability());
        Case savedCase = this.caseRepository.save(newCase);

        return modelMapper.map(savedCase, CaseDTO.class);
    }

    public int getReliability() {
        String phoneNumber = "+363761113334";
        return 5;
    }

    public CaseDTO findCaseById(UUID caseId) {
        return this.modelMapper.map(this.caseRepository.findById(caseId).orElse(null), CaseDTO.class);
    }

    public void createCase(User user) {
        Case newCase = new Case();
        newCase.setUser(user);
        newCase.setCaseType(CaseType.OTHER);
        newCase.setId(UUID.randomUUID());
        newCase.setReliability(this.getReliability());
        this.caseRepository.save(newCase);
    }
}
