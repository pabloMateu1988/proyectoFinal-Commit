package com.sistema.colegio.service;

import java.util.List;

import com.sistema.colegio.model.Curso;

public interface CursoService {
	public List<Curso> listarCursos();
	public void guardar(Curso curso);
	public Curso buscarCursoPorId(Long id);
	public void eliminar(Long id);

}
