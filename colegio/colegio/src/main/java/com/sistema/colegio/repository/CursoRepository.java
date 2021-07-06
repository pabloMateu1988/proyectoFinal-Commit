package com.sistema.colegio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.colegio.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

}
