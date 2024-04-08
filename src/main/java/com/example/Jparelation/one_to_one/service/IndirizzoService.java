package com.example.Jparelation.one_to_one.service;

import com.example.Jparelation.one_to_one.entity.Indirizzo;
import com.example.Jparelation.one_to_one.repository.IndirizzoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IndirizzoService {

    @Autowired
    IndirizzoRepository indirizzoRepository;

    public Indirizzo addIndirizzo(Indirizzo indirizzo) {
        Indirizzo indirizzoNuovo = indirizzoRepository.save(indirizzo);
        return indirizzoNuovo;
    }

    public Optional<Indirizzo> findById(Long id) {
        Optional<Indirizzo> indirizzoOpt = indirizzoRepository.findById(id);

        if(indirizzoOpt.isPresent()) {
            return indirizzoOpt;
        }
        return Optional.empty();
    }

    public List<Indirizzo> findAll() {
        return indirizzoRepository.findAll();
    }

    public Optional<Indirizzo> updateIndirizzo(Long id, Indirizzo indirizzo) {
        Optional<Indirizzo> indirizzoOpt = indirizzoRepository.findById(id);

        if(indirizzoOpt.isPresent()) {
            indirizzoOpt.get().setVia(indirizzo.getVia());
            indirizzoOpt.get().setCitta(indirizzo.getCitta());

            Indirizzo indirizzoUpdated = indirizzoRepository.save(indirizzoOpt.get());
            return Optional.of(indirizzoUpdated);
        }
        return Optional.empty();
    }

    public Optional<Indirizzo> deleteIndirizzo(Long id) {
        Optional<Indirizzo> indirizzoOpt = indirizzoRepository.findById(id);

        if(indirizzoOpt.isPresent()) {
            indirizzoRepository.deleteById(id);
            return indirizzoOpt;
        }
        return Optional.empty();
    }

}
