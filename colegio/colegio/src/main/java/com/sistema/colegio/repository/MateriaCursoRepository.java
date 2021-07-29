package com.sistema.colegio.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sistema.colegio.model.MateriaCurso;


public interface MateriaCursoRepository extends JpaRepository<MateriaCurso, Long> {
	@Query(value = "SELECT * FROM materia_curso WHERE docente_id =:id", nativeQuery = true)
	  List<MateriaCurso> buscarCursoDocente(@Param("id")Long id);

}
