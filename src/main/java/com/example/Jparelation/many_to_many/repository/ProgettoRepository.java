package com.example.Jparelation.many_to_many.repository;

import com.example.Jparelation.many_to_many.entity.Progetto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgettoRepository extends JpaRepository<Progetto, Long> {
}
