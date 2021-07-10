package com.sistema.colegio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistema.colegio.model.Materia;

@Repository
public interface MateriaRepository extends JpaRepository<Materia, Long> {

}
