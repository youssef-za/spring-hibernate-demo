package com.tp.web;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.tp.web"})
public class WebConfig {
    // Configuration MVC minimale : @EnableWebMvc active le support REST/Converters
}

