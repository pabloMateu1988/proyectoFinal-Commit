package com.sistema.colegio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.colegio.model.Alumno;
import com.sistema.colegio.model.Curso;
import com.sistema.colegio.repository.AlumnoRepository;
import com.sistema.colegio.repository.CursoRepository;

@Service
public class AlumnoServiceImplement implements AlumnoService {
	
	@Autowired
	AlumnoRepository alumnoRepository;
	@Autowired
	CursoRepository cursoRepository;

	@Override
	public List<Alumno> listarAlumnos() {
		return alumnoRepository.findAll();
	}

	@Override
	public void guardar(Alumno alumno) {
		alumnoRepository.save(alumno);

	}

	@Override
	public Alumno buscarAlumnoPorId(Long id) {
		return alumnoRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Long id) {
		alumnoRepository.deleteById(id);

	}
}
