package com.example.Jparelation.one_to_one.repository;

import com.example.Jparelation.one_to_one.entity.Indirizzo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndirizzoRepository extends JpaRepository<Indirizzo, Long> {
}
