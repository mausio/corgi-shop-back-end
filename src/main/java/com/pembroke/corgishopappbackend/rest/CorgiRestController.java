package com.pembroke.corgishopappbackend.rest;

import com.pembroke.corgishopappbackend.entity.Corgi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class CorgiRestController {

    @GetMapping("/corgis")
    public List<Corgi> getCorgis() {
        Corgi corgi1 = new Corgi(0, "Robin", 100, "Robin is dog", "", new Date(), "white", 80, 190, true);
        Corgi corgi2 = new Corgi(1, "Mael", 200, "Mael is dog", "", new Date(), "notWhite", 80, 190, true);
        Corgi corgi3 = new Corgi(2, "Lily", 300, "Lily is dog", "", new Date(), "white", 80, 190, true);
        Corgi corgi4 = new Corgi(3, "Luna", 400, "Luna is dog", "", new Date(), "notWhite", 80, 190, true);
        Corgi corgi5 = new Corgi(4, "Luna", 500, "Luna is dog", "", new Date(), "notWhite", 80, 190, true);

        List<Corgi> corgis = new ArrayList<>();
        corgis.add(corgi1);
        corgis.add(corgi2);
        corgis.add(corgi3);
        corgis.add(corgi4);
        corgis.add(corgi5);

        return corgis;
    }

}
