package com.example.Jparelation.one_to_one.controller;

import com.example.Jparelation.one_to_one.entity.Studente;
import com.example.Jparelation.one_to_one.service.StudenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class StudenteController {

    @Autowired
    StudenteService studenteService;

    @PostMapping("/studente")
    public ResponseEntity<Studente> addStudente(@RequestBody Studente studente) {
        Studente studenteNuovo = studenteService.addStudente(studente);
        return ResponseEntity.ok().body(studenteNuovo);
    }

    @GetMapping("/studente/{id}")
    public ResponseEntity<Studente> findById(@PathVariable Long id) {
        Optional<Studente> studenteOpt = studenteService.findById(id);

        if(studenteOpt.isPresent()) {
            return ResponseEntity.ok().body(studenteOpt.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/studenti")
    public ResponseEntity<List<Studente>> findAll() {
        List<Studente> studenti = studenteService.findAll();
        return ResponseEntity.ok().body(studenti);
    }

    @PutMapping("/studente/{id}")
    public ResponseEntity<Studente> updateStudente(@PathVariable Long id, @RequestBody Studente studente) {
        Optional<Studente> studenteOpt = studenteService.updateStudente(id, studente);

        if(studenteOpt.isPresent()) {
            return ResponseEntity.ok().body(studenteOpt.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/studente/{id}")
    public ResponseEntity<Studente> deleteStudente(@PathVariable Long id) {
        Optional<Studente> studenteOpt = studenteService.deleteStudente(id);

        if(studenteOpt.isPresent()){
            return ResponseEntity.ok().body(studenteOpt.get());
        }
        return ResponseEntity.notFound().build();
    }

}
