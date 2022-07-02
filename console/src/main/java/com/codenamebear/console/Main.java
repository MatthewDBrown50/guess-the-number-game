package com.codenamebear.console;

import com.codenamebear.config.GameConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j // Establish Slf4j logger via lombok
public class Main {

    public static void main(String[] args) {

        // create annotation context (container)
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(GameConfig.class);

        context.close();

    }
}
