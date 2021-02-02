package com.bhavik.services.covid19.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public interface ICovid19HealthCheckController {

    @GetMapping(path = "/")
    ResponseEntity<String> getHealthCheck();

}
