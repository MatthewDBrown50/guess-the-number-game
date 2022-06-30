package com.codenamebear.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(GameConfig.class)
@ComponentScan (basePackages = "com.codenamebear") // the argument specifies the location of components to scan for
public class AppConfig {}
