package com.sansa.talentarena;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TalentArenaApplication {

    public static void main(String[] args) {
        SpringApplication.run(TalentArenaApplication.class, args);
    }

}
