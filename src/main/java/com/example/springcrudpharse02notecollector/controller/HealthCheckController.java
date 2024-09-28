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
    public String healthTest(){//mekata call kroth me application eka wada krnawada kiyla blaganna pluwan.
        //me req ekata kisima param ekak one nh.back end eka patte mkut data nh.data walata haniyak wenne nh.back end ekata req ekk ewala balanawa app eka wada krnawada kiyala.
        //meken ganna pluwan nigamanaya thamai app eka wada karanawa.
        return "Note Controller is working";
    }
}
