package com.sistema.colegio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sistema.colegio.model.CursoAlumno;

public interface CursoAlumnoRepository extends JpaRepository<CursoAlumno, Long> {
	@Query(value = "SELECT * FROM curso_alumno WHERE curso_id =:idCurso", nativeQuery = true)
	  List<CursoAlumno> buscarCursoAlumno(@Param("idCurso")Long id);
}
