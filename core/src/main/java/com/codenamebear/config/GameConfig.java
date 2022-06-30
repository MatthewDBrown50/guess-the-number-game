package com.codenamebear.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameConfig {

    private static final int maxNumber = 100;
    private static final int guessCount = 10;

    @Bean
    public int maxNumber(){
        return maxNumber;
    }

    @Bean
    public int guessCount(){
        return guessCount;
    }

}
