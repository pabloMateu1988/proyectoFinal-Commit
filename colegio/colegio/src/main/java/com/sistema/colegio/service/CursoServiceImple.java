package com.sistema.colegio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.colegio.model.Curso;
import com.sistema.colegio.repository.CursoRepository;
@Service
public class CursoServiceImple implements CursoService {
	
	@Autowired
	private CursoRepository cursoRepository;

	@Override
	public List<Curso> listarCursos() {
		
		return cursoRepository.findAll();
	}

	@Override
	public void guardar(Curso curso) {
		cursoRepository.save(curso);

	}

	@Override
	public Curso buscarCursoPorId(Long id) {
		return cursoRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Long id) {
		cursoRepository.deleteById(id);

	}

}
