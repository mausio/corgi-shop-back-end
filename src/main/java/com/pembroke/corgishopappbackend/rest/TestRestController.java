package com.pembroke.corgishopappbackend.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World!";
    }

}