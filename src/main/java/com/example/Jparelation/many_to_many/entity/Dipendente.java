package com.example.Jparelation.many_to_many.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Dipendente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToMany
    @JoinTable(name = "dipendente_progetto",
        joinColumns = @JoinColumn(name = "dipendente_id"),
        inverseJoinColumns = @JoinColumn(name = "progetto_id"))
    private List<Progetto> progetti;

    public Dipendente(Long id, String nome, List<Progetto> progetti) {
        this.id = id;
        this.nome = nome;
        this.progetti = progetti;
    }

    public Dipendente() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Progetto> getProgetti() {
        return progetti;
    }

    public void setProgetti(List<Progetto> progetti) {
        this.progetti = progetti;
    }
}
