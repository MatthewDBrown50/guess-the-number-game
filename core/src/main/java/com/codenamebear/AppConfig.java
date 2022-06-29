package com.codenamebear;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan (basePackages = "com.codenamebear") // the argument specifies the location of components to scan for
public class AppConfig {

}
