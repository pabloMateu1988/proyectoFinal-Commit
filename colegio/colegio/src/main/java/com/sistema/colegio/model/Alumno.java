package com.sistema.colegio.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("Alumno")
@Getter
@Setter
public class Alumno extends Persona implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ManyToMany 
	private List<Curso> cursos = new ArrayList<Curso>();
	
}
