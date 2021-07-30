package com.sistema.colegio.dtos;

import java.util.Date;
import java.util.List;

import com.sistema.colegio.model.Curso;
import com.sistema.colegio.model.CursoAlumno;
import com.sistema.colegio.model.Materia;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PasarLista {
	
	private String fecha;
	private Materia materia;
	private Curso curso;
	private String observaciones;
	private List<CursoAlumno> alumnos;
	private Boolean asistio=true;
	
	public PasarLista(String fecha, Materia materia, Curso curso, List<CursoAlumno> alumnos, String observaciones) {
		this.fecha = fecha;
		this.materia = materia;
		this.curso = curso;
		this.alumnos = alumnos;
		this.observaciones = observaciones;

	}

	

}
