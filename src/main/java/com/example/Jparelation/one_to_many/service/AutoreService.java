package com.example.Jparelation.one_to_many.service;

import com.example.Jparelation.one_to_many.entity.Autore;
import com.example.Jparelation.one_to_many.repository.AutoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutoreService {

    @Autowired
    AutoreRepository autoreRepository;

    public Autore addAutore(Autore autore) {
        Autore autoreNuovo = autoreRepository.save(autore);
        return autoreNuovo;
    }

    public Optional<Autore> findById(Long id) {
        Optional<Autore> autoreOpt = autoreRepository.findById(id);

        if(autoreOpt.isPresent()) {
            return autoreOpt;
        }
        return Optional.empty();
    }

    public List<Autore> findAll() {
        return autoreRepository.findAll();
    }

    public Optional<Autore> updateAutore(Long id, Autore autore) {
        Optional<Autore> autoreOpt = autoreRepository.findById(id);

        if(autoreOpt.isPresent()) {
            autoreOpt.get().setNome(autore.getNome());
            autoreOpt.get().setLibro(autore.getLibro());

            Autore autoreUpdated = autoreRepository.save(autoreOpt.get());
            return Optional.of(autoreUpdated);
        }
        return Optional.empty();
    }

    public Optional<Autore> deleteAutore(Long id) {
        Optional<Autore> autoreOpt = autoreRepository.findById(id);

        if(autoreOpt.isPresent()) {
            autoreRepository.deleteById(id);
            return autoreOpt;
        }
        return Optional.empty();
    }

}

