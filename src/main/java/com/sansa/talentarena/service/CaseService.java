package com.sansa.talentarena.service;

import com.sansa.talentarena.SimSwapClient;
import com.sansa.talentarena.model.entity.Case;
import com.sansa.talentarena.model.entity.User;
import com.sansa.talentarena.model.enumerates.CaseType;
import com.sansa.talentarena.repository.CaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CaseService {

    private final CaseRepository caseRepository;
    private final SimSwapClient simSwapClient;

    public List<Case> findAllCases() {
        return (List<Case>) this.caseRepository.findAll();
    }

    public Case createCase(CaseType caseType) {
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Case newCase = new Case();
        newCase.setUser(currentUser);
        newCase.setCaseType(caseType);
        newCase.setReliability(this.getReliability());
        return newCase;
    }

    public int getReliability() {
        String phoneNumber = "+363761113334";
        HashMap<String, Object> response = simSwapClient.checkSimDate(phoneNumber).block();
        System.out.println(response);
        return 5;
    }
}
