package com.example.Jparelation.many_to_many.service;

import com.example.Jparelation.many_to_many.entity.Progetto;
import com.example.Jparelation.many_to_many.repository.ProgettoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProgettoService {

    @Autowired
    ProgettoRepository progettoRepository;

    public Progetto addProgetto(Progetto progetto) {
        Progetto progettoNuovo = progettoRepository.save(progetto);
        return progettoNuovo;
    }

    public Optional<Progetto> findById(Long id) {
        Optional<Progetto> progettoOpt = progettoRepository.findById(id);

        if(progettoOpt.isPresent()) {
            return progettoOpt;
        }
        return Optional.empty();
    }

    public List<Progetto> findAll() {
        return progettoRepository.findAll();
    }

    public Optional<Progetto> updateProgetto(Long id, Progetto progetto) {
        Optional<Progetto> progettoOpt = progettoRepository.findById(id);

        if(progettoOpt.isPresent()) {
            progettoOpt.get().setNome(progetto.getNome());
            progettoOpt.get().setDipendenti(progetto.getDipendenti());

            Progetto progettoUpdated = progettoRepository.save(progettoOpt.get());
            return Optional.of(progettoUpdated);
        }
        return Optional.empty();
    }

    public Optional<Progetto> deleteProgetto(Long id) {
        Optional<Progetto> progettoOpt = progettoRepository.findById(id);

        if(progettoOpt.isPresent()) {
            progettoRepository.deleteById(id);
            return progettoOpt;
        }
        return Optional.empty();
    }

}
