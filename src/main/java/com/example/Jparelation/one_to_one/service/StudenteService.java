package com.example.Jparelation.one_to_one.service;

import com.example.Jparelation.one_to_one.entity.Studente;
import com.example.Jparelation.one_to_one.repository.StudenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudenteService {

    @Autowired
    private StudenteRepository studenteRepository;

    public Studente addStudente(Studente studente) {
        Studente studenteNuovo = studenteRepository.save(studente);
        return studenteNuovo;
    }

    public Optional<Studente> findById(Long id) {
        Optional<Studente> studenteOpt = studenteRepository.findById(id);

        if(studenteOpt.isPresent()) {
            return studenteOpt;
        }
        return Optional.empty();
    }

    public List<Studente> findAll() {
        return studenteRepository.findAll();
    }

    public Optional<Studente> updateStudente(Long id, Studente studente) {
        Optional<Studente> studenteOpt = studenteRepository.findById(id);

        if(studenteOpt.isPresent()) {
            studenteOpt.get().setNome(studente.getNome());
            studenteOpt.get().setIndirizzo(studente.getIndirizzo());

            Studente studenteUpdated = studenteRepository.save(studenteOpt.get());
            return Optional.of(studenteUpdated);
        }
        return Optional.empty();
    }

    public Optional<Studente> deleteStudente(Long id) {
        Optional<Studente> studenteOpt = studenteRepository.findById(id);

        if(studenteOpt.isPresent()) {
            studenteRepository.deleteById(id);
            return studenteOpt;
        }
        return Optional.empty();
    }
}