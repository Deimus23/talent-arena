package com.sansa.talentarena.controller;

import com.sansa.talentarena.SimSwapClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;


@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {
    private final SimSwapClient simSwapClient;

    @PostMapping("/sim")
    public HashMap<String, Object> test() {
        HashMap<String, Object> res = this.simSwapClient.checkSimDate("+363761113334").block();
        System.out.println("break");
        return res;
    }
}
