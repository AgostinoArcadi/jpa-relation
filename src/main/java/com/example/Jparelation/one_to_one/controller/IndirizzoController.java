package com.example.Jparelation.one_to_one.controller;

import com.example.Jparelation.one_to_one.entity.Indirizzo;
import com.example.Jparelation.one_to_one.service.IndirizzoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class IndirizzoController {

    @Autowired
    IndirizzoService indirizzoService;

    @PostMapping("/indirizzo")
    public ResponseEntity<Indirizzo> addIndirizzo(@RequestBody Indirizzo indirizzo) {
        Indirizzo indirizzoNuovo = indirizzoService.addIndirizzo(indirizzo);
        return ResponseEntity.ok().body(indirizzoNuovo);
    }

    @GetMapping("/indirizzo/{id}")
    public ResponseEntity<Indirizzo> findById(@PathVariable Long id) {
        Optional<Indirizzo> indirizzoOpt = indirizzoService.findById(id);

        if(indirizzoOpt.isPresent()) {
            return ResponseEntity.ok().body(indirizzoOpt.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/indirizzi")
    public ResponseEntity<List<Indirizzo>> findAll() {
        List<Indirizzo> indirizzi = indirizzoService.findAll();
        return ResponseEntity.ok().body(indirizzi);
    }

    @PutMapping("/indirizzo/{id}")
    public ResponseEntity<Indirizzo> updateIndirizzo(@PathVariable Long id, @RequestBody Indirizzo indirizzo) {
        Optional<Indirizzo> indirizzoOpt = indirizzoService.updateIndirizzo(id, indirizzo);

        if(indirizzoOpt.isPresent()) {
            return ResponseEntity.ok().body(indirizzoOpt.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/indirizzo/{id}")
    public ResponseEntity<Indirizzo> deleteIndirizzo(@PathVariable Long id) {
        Optional<Indirizzo> indirizzoOpt = indirizzoService.deleteIndirizzo(id);

        if(indirizzoOpt.isPresent()){
            return ResponseEntity.ok().body(indirizzoOpt.get());
        }
        return ResponseEntity.notFound().build();
    }
}
