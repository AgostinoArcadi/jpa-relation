package com.example.Jparelation.one_to_many.service;

import com.example.Jparelation.one_to_many.entity.Libro;
import com.example.Jparelation.one_to_many.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

    @Autowired
    LibroRepository libroRepository;

    public Libro addLibro(Libro libro) {
        Libro libroNuovo = libroRepository.save(libro);
        return libroNuovo;
    }

    public Optional<Libro> findById(Long id) {
        Optional<Libro> libroOpt = libroRepository.findById(id);

        if(libroOpt.isPresent()) {
            return libroOpt;
        }
        return Optional.empty();
    }

    public List<Libro> findAll() {
        return libroRepository.findAll();
    }

    public Optional<Libro> updateLibro(Long id, Libro libro) {
        Optional<Libro> libroOpt = libroRepository.findById(id);

        if(libroOpt.isPresent()) {
            libroOpt.get().setTitolo(libro.getTitolo());
            libroOpt.get().setAutori(libro.getAutori());

            Libro libroUpdated = libroRepository.save(libroOpt.get());
            return Optional.of(libroUpdated);
        }
        return Optional.empty();
    }

    public Optional<Libro> deleteLibro(Long id) {
        Optional<Libro> libroOpt = libroRepository.findById(id);

        if(libroOpt.isPresent()) {
            libroRepository.deleteById(id);
            return libroOpt;
        }
        return Optional.empty();
    }

}
