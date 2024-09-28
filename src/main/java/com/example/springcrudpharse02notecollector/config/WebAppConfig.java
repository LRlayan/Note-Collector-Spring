package com.example.springcrudpharse02notecollector.config;

import jakarta.servlet.annotation.MultipartConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "com.example.springcrudpharse02notecollector")
@EnableWebMvc
@MultipartConfig
public class WebAppConfig {
}
