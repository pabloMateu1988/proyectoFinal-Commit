package com.sistema.colegio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sistema.colegio.model.Alumno;
import com.sistema.colegio.model.Curso;

@Service
public interface AlumnoService {

	public List<Alumno> listarAlumnos();
	public void guardar(Alumno alumno);
	public Alumno buscarAlumnoPorId(Long id);
	public void eliminar(Long id);

}
