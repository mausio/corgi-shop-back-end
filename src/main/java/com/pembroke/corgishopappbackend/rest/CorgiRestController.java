package com.pembroke.corgishopappbackend.rest;

import com.pembroke.corgishopappbackend.dto.CorgiDTO;
import com.pembroke.corgishopappbackend.entity.Corgi;
import com.pembroke.corgishopappbackend.service.CorgiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
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

    @GetMapping("/saveCorgis")
    public ResponseEntity saveCorgisInLocalDatabase() {

        Corgi corgi1 = new Corgi("Robin", 100, "Robin is dog", "", new Date(), "white", 80, 190, true);
        Corgi corgi2 = new Corgi("Mael", 200, "Mael is dog", "", new Date(), "notWhite", 80, 190, true);
        Corgi corgi3 = new Corgi("Lily", 300, "Lily is dog", "", new Date(), "white", 80, 190, true);
        Corgi corgi4 = new Corgi("Luna", 400, "Luna is dog", "", new Date(), "notWhite", 80, 190, true);
        Corgi corgi5 = new Corgi("Luna", 500, "Luna is dog", "", new Date(), "notWhite", 80, 190, true);

        corgiService.save(corgi1);
        corgiService.save(corgi2);
        corgiService.save(corgi3);
        corgiService.save(corgi4);
        corgiService.save(corgi5);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    /*
    @GetMapping("/corgis")
    public List<Corgi> getCorgis() {
        Corgi corgi1 = new Corgi("Robin", 100, "Robin is dog", "", new Date(), "white", 80, 190, true);
        Corgi corgi2 = new Corgi("Mael", 200, "Mael is dog", "", new Date(), "notWhite", 80, 190, true);
        Corgi corgi3 = new Corgi("Lily", 300, "Lily is dog", "", new Date(), "white", 80, 190, true);
        Corgi corgi4 = new Corgi("Luna", 400, "Luna is dog", "", new Date(), "notWhite", 80, 190, true);
        Corgi corgi5 = new Corgi("Luna", 500, "Luna is dog", "", new Date(), "notWhite", 80, 190, true);

        List<Corgi> corgis = new ArrayList<>();
        corgis.add(corgi1);
        corgis.add(corgi2);
        corgis.add(corgi3);
        corgis.add(corgi4);
        corgis.add(corgi5);

        return corgis;
    }

     */

}
