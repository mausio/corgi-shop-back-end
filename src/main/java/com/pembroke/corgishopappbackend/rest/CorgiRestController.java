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

    //TODO: Delete this method when using a final Database
    @GetMapping("/saveCorgis")
    public ResponseEntity saveCorgisInLocalDatabase() {

        Corgi corgi1 = new Corgi("Robin", 100, "Robin is dog", "https://www.akc.org/wp-content/uploads/2017/11/Pembroke-Welsh-Corgi-standing-outdoors-in-the-fall-400x267.jpg", new Date(), "white", 80, 190, true);
        Corgi corgi2 = new Corgi("Mael", 200, "Mael is dog", "https://www.zooplus.de/magazin/wp-content/uploads/2017/07/Welsh-Corgi-Pembroke-sitzt-in-der-Natur-1024x682.jpeg", new Date(), "notWhite", 80, 190, true);
        Corgi corgi3 = new Corgi("Lily", 300, "Lily is dog", "https://www.purina.de/sites/default/files/styles/ttt_image_510/public/2021-01/Welsh%20Corgi%20%28Pembroke%291.jpg?itok=-ALFB8xn", new Date(), "white", 80, 190, true);
        Corgi corgi4 = new Corgi("Luna", 400, "Luna is dog", "https://www.tierchenwelt.de/images/stories/haustiere/hunde/welsh_corgi_hunderasse_l.jpg", new Date(), "notWhite", 80, 190, true);
        Corgi corgi5 = new Corgi("Luna", 500, "Luna is dog", "https://www.hundeo.com/wp-content/uploads/2019/04/Welsh-Corgi-Pembroke-glu%CC%88cklich.jpg", new Date(), "notWhite", 80, 190, true);

        corgiService.save(corgi1);
        corgiService.save(corgi2);
        corgiService.save(corgi3);
        corgiService.save(corgi4);
        corgiService.save(corgi5);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}