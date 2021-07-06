package com.sistema.colegio.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.sistema.colegio.model.Materia;

public interface MateriaRepository extends JpaRepository<Materia, Long> {

}
