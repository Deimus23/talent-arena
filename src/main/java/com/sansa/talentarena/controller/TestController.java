package com.sansa.talentarena.controller;

import com.sansa.talentarena.client.LocationVerifier;
import com.sansa.talentarena.model.dto.locationverifier.VerifyLocationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;


@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {
    private final LocationVerifier locationVerifier;

    @PostMapping("/sim")
    public String test() {
        var verifyLocationRequest = new VerifyLocationRequest("+34650040771", 41.598817f, 2.347965f);
        boolean res = locationVerifier.isOutside(verifyLocationRequest);
        System.out.println("break");
        return "res";
    }
}
