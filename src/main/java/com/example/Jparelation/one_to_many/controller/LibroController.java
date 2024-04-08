package com.example.Jparelation.one_to_many.controller;

import com.example.Jparelation.one_to_many.entity.Libro;
import com.example.Jparelation.one_to_many.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class LibroController {

    @Autowired
    LibroService libroService;

    @PostMapping("/libro")
    public ResponseEntity<Libro> addLibro(@RequestBody Libro libro) {
        Libro libroNuovo = libroService.addLibro(libro);
        return ResponseEntity.ok().body(libroNuovo);
    }

    @GetMapping("/libro/{id}")
    public ResponseEntity<Libro> findById(@PathVariable Long id) {
        Optional<Libro> libroOpt = libroService.findById(id);

        if(libroOpt.isPresent()) {
            return ResponseEntity.ok().body(libroOpt.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/libri")
    public ResponseEntity<List<Libro>> findAll() {
        List<Libro> libri = libroService.findAll();
        return ResponseEntity.ok().body(libri);
    }

    @PutMapping("/libro/{id}")
    public ResponseEntity<Libro> updateLibro(@PathVariable Long id, @RequestBody Libro libro) {
        Optional<Libro> libroOpt = libroService.updateLibro(id, libro);

        if(libroOpt.isPresent()) {
            return ResponseEntity.ok().body(libroOpt.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/libro/{id}")
    public ResponseEntity<Libro> deleteLibro(@PathVariable Long id) {
        Optional<Libro> libroOpt = libroService.deleteLibro(id);

        if(libroOpt.isPresent()){
            return ResponseEntity.ok().body(libroOpt.get());
        }
        return ResponseEntity.notFound().build();
    }
}
