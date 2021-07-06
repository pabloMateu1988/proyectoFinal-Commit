package com.sistema.colegio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.colegio.model.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {

}
