package com.sistema.colegio.model;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("Docente")
@Getter
@Setter
public class Docente extends Persona implements Serializable{
	private static final long serialVersionUID = 1L;
	@OneToOne
	private Materia materia;

}
