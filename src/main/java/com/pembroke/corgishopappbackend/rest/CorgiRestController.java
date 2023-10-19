package com.pembroke.corgishopappbackend.rest;

import com.pembroke.corgishopappbackend.entity.Corgi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CorgiRestController {

    @GetMapping("/corgis")
    public List<Corgi> getCorgis() {
        Corgi corgi1 = new Corgi(1, "Robin", 100, true, "Robin is dog", "");
        Corgi corgi2 = new Corgi(2, "Lily", 200, false, "Lily is dog", "");
        Corgi corgi3 = new Corgi(3, "Ted", 300, false, "Ted is dog", "");
        Corgi corgi4 = new Corgi(4, "Marshall", 400, false, "Marshall is dog", "");
        Corgi corgi5 = new Corgi(5, "Barney", 500, true, "Barney is dog", "");

        List<Corgi> corgis = new ArrayList<>();
        corgis.add(corgi1);
        corgis.add(corgi2);
        corgis.add(corgi3);
        corgis.add(corgi4);
        corgis.add(corgi5);

        return corgis;
    }

}
