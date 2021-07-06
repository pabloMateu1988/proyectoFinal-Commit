package com.sistema.colegio.model;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("Alumno")
@Getter
@Setter
public class Alumno extends Persona implements Serializable {
	private static final long serialVersionUID = 1L;
	@ManyToOne
	private Curso curso;
	@OneToOne
	private Materia materia;
}
