package com.example.Jparelation.many_to_many.controller;

import com.example.Jparelation.many_to_many.entity.Progetto;
import com.example.Jparelation.many_to_many.service.ProgettoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class ProgettoController {

    @Autowired
    ProgettoService progettoService;

    @PostMapping("/progetto")
    public ResponseEntity<Progetto> addProgetto(@RequestBody Progetto progetto) {
        Progetto progettoNuovo = progettoService.addProgetto(progetto);
        return ResponseEntity.ok().body(progettoNuovo);
    }

    @GetMapping("/progetto/{id}")
    public ResponseEntity<Progetto> findById(@PathVariable Long id) {
        Optional<Progetto> progettoOpt = progettoService.findById(id);

        if(progettoOpt.isPresent()) {
            return ResponseEntity.ok().body(progettoOpt.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/progetti")
    public ResponseEntity<List<Progetto>> findAll() {
        List<Progetto> progetti = progettoService.findAll();
        return ResponseEntity.ok().body(progetti);
    }

    @PutMapping("/progetto/{id}")
    public ResponseEntity<Progetto> updateProgetto(@PathVariable Long id, @RequestBody Progetto progetto) {
        Optional<Progetto> progettoOpt = progettoService.updateProgetto(id, progetto);

        if(progettoOpt.isPresent()) {
            return ResponseEntity.ok().body(progettoOpt.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/progetto/{id}")
    public ResponseEntity<Progetto> deleteProgetto(@PathVariable Long id) {
        Optional<Progetto> progettoOpt = progettoService.deleteProgetto(id);

        if(progettoOpt.isPresent()){
            return ResponseEntity.ok().body(progettoOpt.get());
        }
        return ResponseEntity.notFound().build();
    }
}
