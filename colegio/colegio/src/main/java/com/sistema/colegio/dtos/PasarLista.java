package com.sistema.colegio.dtos;

import java.util.Date;
import java.util.List;

import com.sistema.colegio.model.Alumno;

public class PasarLista {
	
	private Date fecha;
	private MateriaDto materia;
	private CursoDto curso;
	private List<AlumnoAsistenciaDto> alumnos;
	
	public PasarLista(Date fecha, MateriaDto materia, CursoDto curso, List<AlumnoAsistenciaDto> alumnos) {
		this.fecha = fecha;
		this.materia = materia;
		this.curso = curso;
		this.alumnos = alumnos;
	}

	

}
