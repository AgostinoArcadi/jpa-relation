package com.example.Jparelation.one_to_many.repository;

import com.example.Jparelation.one_to_many.entity.Autore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoreRepository extends JpaRepository<Autore, Long> {
}
