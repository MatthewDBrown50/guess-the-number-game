package com.codenamebear.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.codenamebear") // the argument specifies the location of components to scan for
@PropertySource("classpath:config/game.properties")
public class GameConfig {

    @Value("${game.maxNumber}")
    private int maxNumber;

    @Value("${game.minNumber}")
    private int minNumber;

    @Value("${game.guessCount}")
    private int guessCount;

    @Bean
    public int maxNumber(){
        return maxNumber;
    }

    @Bean
    public int minNumber(){
        return minNumber;
    }

    @Bean
    public int guessCount(){
        return guessCount;
    }

}
