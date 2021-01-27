package com.bhavik.services.covid19.api.controller;

import com.bhavik.services.covid19.api.model.Covid19State;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public interface ICovid19StatesController {

    @GetMapping(path = "/states")
    List<Covid19State> getAllCovid19States();

    @PostMapping(path = "/states")
    ResponseEntity<String> createCovid19States(@RequestBody List<Covid19State> states);

}
