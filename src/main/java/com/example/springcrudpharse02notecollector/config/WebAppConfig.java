package com.example.springcrudpharse02notecollector.config;

import jakarta.servlet.annotation.MultipartConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "com.example.springcrudpharse02notecollector")
@EnableWebMvc
@MultipartConfig(
                 fileSizeThreshold = 1024 * 1024 * 2,
                 maxFileSize = 1024 * 1024 * 3,
                 maxRequestSize = 1024 * 1024 * 10
)
public class WebAppConfig {
    //pro pic eka server ekt upload karama meka procces karanna one.2mp walata wada aduinm primery memoery eke proces weno.ekata wada wadinm scondory memory ekata bara deno.me value damme nttn mewa default tiyenne unlimited
    //me app ekata updalod kranna pluwn file size eka kiyada,
    //multipart form configuration meke enble krla tiyenne kiyla meken kiyanna pluwn // me annotation eka meke damme adala data eka enne controller class ekata ethkot e data eka handle wenne controller class eken.e nisa eka controller class ekata damme.mulitipart kiynne controller class ekata adala configuration ekak.
}
