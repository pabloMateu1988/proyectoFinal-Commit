package com.sistema.colegio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sistema.colegio.model.CursoAlumno;

@Service
public interface CursoAlumnoService {
	public List<CursoAlumno> listarCursoAlumno();
	public void guardar(CursoAlumno cursoAlumno);
	public CursoAlumno buscarPorId(Long id);
	public void eliminar(Long id);

}
