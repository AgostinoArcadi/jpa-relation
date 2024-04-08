package com.example.Jparelation.many_to_many.controller;

import com.example.Jparelation.many_to_many.entity.Dipendente;
import com.example.Jparelation.many_to_many.service.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class DipendenteController {

    @Autowired
    DipendenteService dipendenteService;

    @PostMapping("/dipendente")
    public ResponseEntity<Dipendente> addDipendente(@RequestBody Dipendente dipendente) {
        Dipendente dipendenteNuovo = dipendenteService.addDipendente(dipendente);
        return ResponseEntity.ok().body(dipendenteNuovo);
    }

    @GetMapping("/dipendente/{id}")
    public ResponseEntity<Dipendente> findById(@PathVariable Long id) {
        Optional<Dipendente> dipendenteOpt = dipendenteService.findById(id);

        if(dipendenteOpt.isPresent()) {
            return ResponseEntity.ok().body(dipendenteOpt.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/dipendenti")
    public ResponseEntity<List<Dipendente>> findAll() {
        List<Dipendente> dipendenti = dipendenteService.findAll();
        return ResponseEntity.ok().body(dipendenti);
    }

    @PutMapping("/dipendente/{id}")
    public ResponseEntity<Dipendente> updateDipendente(@PathVariable Long id, @RequestBody Dipendente dipendente) {
        Optional<Dipendente> dipendenteOpt = dipendenteService.updateDipendente(id, dipendente);

        if(dipendenteOpt.isPresent()) {
            return ResponseEntity.ok().body(dipendenteOpt.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/dipendente/{id}")
    public ResponseEntity<Dipendente> deleteDipendente(@PathVariable Long id) {
        Optional<Dipendente> dipendenteOpt = dipendenteService.deleteDipendente(id);

        if(dipendenteOpt.isPresent()){
            return ResponseEntity.ok().body(dipendenteOpt.get());
        }
        return ResponseEntity.notFound().build();
    }
}
