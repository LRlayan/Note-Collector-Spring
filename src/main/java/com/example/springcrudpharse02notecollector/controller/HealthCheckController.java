package com.example.springcrudpharse02notecollector.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/health")
public class HealthCheckController {
    //serama end point up unada blanna apita health controller ekak hadanna pluwan.

    @GetMapping
    public String healthTest(){
        return "Server is working";
    }
}
