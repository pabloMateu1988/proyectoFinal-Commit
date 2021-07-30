package com.sistema.colegio.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

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
	private String fecha;
	private Boolean asistio=true;
	private String observaciones;
	@OneToOne
	private Curso curso;
	@OneToOne
	private Alumno alumno;
	@OneToOne
	private Materia materia;

	
	
 


}
