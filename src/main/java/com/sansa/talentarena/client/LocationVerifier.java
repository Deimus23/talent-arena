package com.sansa.talentarena.client;

import com.sansa.talentarena.model.dto.locationverifier.VerifyLocationRequest;
import com.sansa.talentarena.model.dto.locationverifier.VerifyLocationResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.HashMap;


@Component
public class LocationVerifier {

    private final WebClient webClient;

    public LocationVerifier(@Value("${talent-arena.client.location-verifier.host}") String host,
                            @Value("${talent-arena.client.apiKey}") String apiKey,
                            @Value("${talent-arena.client.location-verifier.baseUrl}") String baseUrl
    ) {
        this.webClient = WebClient.builder()
                .baseUrl(baseUrl)
                .defaultHeader("X-RapidAPI-Key", apiKey)
                .defaultHeader("X-RapidAPI-Host", host) // Cambia según la API
                .defaultHeader("Content-Type", "application/json")
                .build();
    }

    public boolean isOutside(VerifyLocationRequest verifyLocationRequest) {
        boolean outsideCircle;
        try {
            VerifyLocationResponse res = this.webClient.post()
                    .uri("/verify")
                    .bodyValue(verifyLocationRequest)
                    .retrieve()
                    .bodyToMono(VerifyLocationResponse.class).block();
            outsideCircle = !res.getVerificationResult().equals("TRUE");
        } catch (WebClientResponseException e ){
            outsideCircle = false;
        }

        return outsideCircle;
    }

}

