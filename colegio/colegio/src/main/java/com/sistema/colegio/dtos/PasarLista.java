package com.sistema.colegio.dtos;

import java.util.Date;
import java.util.List;

import com.sistema.colegio.controller.AlumnoDto;
import com.sistema.colegio.model.Alumno;
import com.sistema.colegio.model.Curso;
import com.sistema.colegio.model.CursoAlumno;
import com.sistema.colegio.model.Materia;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class PasarLista {
	
	private Date fecha;
	private Materia materia;
	private CursoAlumno curso;
	private List<CursoAlumno> alumnos;
	private Boolean asistio=true;
	
	public PasarLista(Date fecha, Materia materia, CursoAlumno curso, List<CursoAlumno> alumnos) {
		this.fecha = fecha;
		this.materia = materia;
		this.curso = curso;
		this.alumnos = alumnos;

	}

	

}
