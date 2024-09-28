package com.example.springcrudpharse02notecollector.config;

import jakarta.servlet.annotation.MultipartConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "com.example.springcrudpharse02notecollector")
@EnableWebMvc
@MultipartConfig //multipart form configuration meke enble krla tiyenne kiyla meken kiyanna pluwn // me annotation eka meke damme adala data eka enne controller class ekata ethkot e data eka handle wenne controller class eken.e nisa eka controller class ekata damme.mulitipart kiynne controller class ekata adala configuration ekak.
public class WebAppConfig {
}
