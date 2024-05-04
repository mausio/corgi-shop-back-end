package com.pembroke.corgishopappbackend.rest;

import com.pembroke.corgishopappbackend.dto.CorgiDTO;
import com.pembroke.corgishopappbackend.service.CorgiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CorgiRestController {

    private final CorgiService corgiService;

    @Autowired
    public CorgiRestController(CorgiService corgiService) {
        this.corgiService = corgiService;
    }

    @GetMapping("/corgis")
    public ResponseEntity<List<CorgiDTO>> getAllCorgis() {
        return  ResponseEntity.status(HttpStatus.OK).body(corgiService.findAll());
    }
}