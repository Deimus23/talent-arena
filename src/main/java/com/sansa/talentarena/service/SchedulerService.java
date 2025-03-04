package com.sansa.talentarena.service;

import com.sansa.talentarena.client.LocationVerifier;
import com.sansa.talentarena.model.dto.locationverifier.VerifyLocationRequest;
import com.sansa.talentarena.model.entity.User;
import com.sansa.talentarena.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchedulerService {
    private final UserRepository userRepository;
    private final LocationVerifier locationVerifier;
    private final CaseService caseService;

    @Scheduled(cron = "0 */10 * * * *")
    public void scheduledLocationCheck() {
        List<User> users = (List<User>) userRepository.findAll();
        for (User user : users) {
            var verifyLocationRequest = new VerifyLocationRequest(user.getPhone(), 20f, 20f); //cambiar por guardadas en bbdd
            if (locationVerifier.isOutside(verifyLocationRequest)) {
                this.caseService.createCase(user);
            }
        }
    }

}
