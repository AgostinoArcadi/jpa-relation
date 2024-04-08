package com.example.Jparelation.one_to_many.controller;

import com.example.Jparelation.one_to_many.entity.Autore;
import com.example.Jparelation.one_to_many.service.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class AutoreController {

    @Autowired
    AutoreService autoreService;

    @PostMapping("/autore")
    public ResponseEntity<Autore> addAutore(@RequestBody Autore autore) {
        Autore autoreNuovo = autoreService.addAutore(autore);
        return ResponseEntity.ok().body(autoreNuovo);
    }

    @GetMapping("/autore/{id}")
    public ResponseEntity<Autore> findById(@PathVariable Long id) {
        Optional<Autore> autoreOpt = autoreService.findById(id);

        if(autoreOpt.isPresent()) {
            return ResponseEntity.ok().body(autoreOpt.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/autori")
    public ResponseEntity<List<Autore>> findAll() {
        List<Autore> autori = autoreService.findAll();
        return ResponseEntity.ok().body(autori);
    }

    @PutMapping("/autore/{id}")
    public ResponseEntity<Autore> updateAutore(@PathVariable Long id, @RequestBody Autore autore) {
        Optional<Autore> autoreOpt = autoreService.updateAutore(id, autore);

        if(autoreOpt.isPresent()) {
            return ResponseEntity.ok().body(autoreOpt.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/autore/{id}")
    public ResponseEntity<Autore> deleteAutore(@PathVariable Long id) {
        Optional<Autore> autoreOpt = autoreService.deleteAutore(id);

        if(autoreOpt.isPresent()){
            return ResponseEntity.ok().body(autoreOpt.get());
        }
        return ResponseEntity.notFound().build();
    }
}
