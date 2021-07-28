package com.sistema.colegio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistema.colegio.model.Docente;

@Repository
public interface DocenteRepository extends JpaRepository<Docente, Long> {


}
