package com.sistema.colegio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sistema.colegio.model.Docente;
import com.sistema.colegio.model.MateriaCurso;

@Service
public interface MateriaCursoService {
	
	public List<MateriaCurso> listarMateriasCurso();
	public void guardar(MateriaCurso materiaCurso);
	public MateriaCurso buscarPorId(Long id);
	public void eliminar(Long id);
	public Docente buscarDocentePorId(Long id);

}
