package com.sistema.colegio.model;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.sistema.colegio.dtos.CursoDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Asistencia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date fecha;
	private Boolean asistio=true;
	private String observaciones;
	@OneToOne
	private Curso curso;
	@OneToOne
	private Alumno alumno;
	@OneToOne
	private Materia materia;

	
	
 


}
