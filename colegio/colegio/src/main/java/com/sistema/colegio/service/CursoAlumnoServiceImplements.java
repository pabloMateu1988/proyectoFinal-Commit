package com.sistema.colegio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.colegio.model.CursoAlumno;
import com.sistema.colegio.repository.CursoAlumnoRepository;
@Service
public class CursoAlumnoServiceImplements implements CursoAlumnoService {
	
	@Autowired
	CursoAlumnoRepository cursoAlumnoRepository;

	@Override
	public List<CursoAlumno> listarCursoAlumno() {
		return cursoAlumnoRepository.findAll();
	}

	@Override
	public void guardar(CursoAlumno cursoAlumno) {
		cursoAlumnoRepository.saveAndFlush(cursoAlumno);

	}

	@Override
	public CursoAlumno buscarPorId(Long id) {
		return cursoAlumnoRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Long id) {
		cursoAlumnoRepository.deleteById(id);

	}

}
