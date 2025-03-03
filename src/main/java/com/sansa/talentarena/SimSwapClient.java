package com.sansa.talentarena;

import com.sansa.talentarena.model.dto.CheckSimReqDTO;
import lombok.RequiredArgsConstructor;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.HashMap;

@Service
public class SimSwapClient {

    private final WebClient webClient;

    public SimSwapClient(@Value("${talent-arena.client.sim-swap.host}") String host,
                          @Value("${talent-arena.client.sim-swap.apiKey}") String apiKey,
                         @Value("${talent-arena.client.sim-swap.baseUrl}") String baseUrl
                         ) {
        this.webClient = WebClient.builder()
                .baseUrl(baseUrl)
                .defaultHeader("X-RapidAPI-Key", apiKey)
                .defaultHeader("X-RapidAPI-Host", host) // Cambia según la API
                .defaultHeader("Content-Type", "application/json")
                .build();
    }

    public Mono<HashMap<String, Object>> checkSimDate(String phoneNumber) {
        return webClient.post()
                .uri(uriBuilder -> uriBuilder
                        .path("/sim-swap/sim-swap/v0/retrieve-date")
                        .build())
                .bodyValue(new CheckSimReqDTO(phoneNumber))
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<HashMap<String, Object>>() {});
    }



}
