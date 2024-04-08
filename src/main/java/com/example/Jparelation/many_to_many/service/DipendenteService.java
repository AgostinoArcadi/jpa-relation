package com.example.Jparelation.many_to_many.service;

import com.example.Jparelation.many_to_many.entity.Dipendente;
import com.example.Jparelation.many_to_many.repository.DipendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DipendenteService {

    @Autowired
    DipendenteRepository dipendenteRepository;

    public Dipendente addDipendente(Dipendente dipendente) {
        Dipendente dipendenteNuovo = dipendenteRepository.save(dipendente);
        return dipendenteNuovo;
    }

    public Optional<Dipendente> findById(Long id) {
        Optional<Dipendente> dipendenteOpt = dipendenteRepository.findById(id);

        if(dipendenteOpt.isPresent()) {
            return dipendenteOpt;
        }
        return Optional.empty();
    }

    public List<Dipendente> findAll() {
        return dipendenteRepository.findAll();
    }

    public Optional<Dipendente> updateDipendente(Long id, Dipendente dipendente) {
        Optional<Dipendente> dipendenteOpt = dipendenteRepository.findById(id);

        if(dipendenteOpt.isPresent()) {
            dipendenteOpt.get().setNome(dipendente.getNome());
            dipendenteOpt.get().setProgetti(dipendente.getProgetti());

            Dipendente dipendenteUpdated = dipendenteRepository.save(dipendenteOpt.get());
            return Optional.of(dipendenteUpdated);
        }
        return Optional.empty();
    }

    public Optional<Dipendente> deleteDipendente(Long id) {
        Optional<Dipendente> dipendenteOpt = dipendenteRepository.findById(id);

        if(dipendenteOpt.isPresent()) {
            dipendenteRepository.deleteById(id);
            return dipendenteOpt;
        }
        return Optional.empty();
    }

}
