package com.sistema.colegio.model;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue("Alumno")
@Getter
@Setter
@NoArgsConstructor
public class Alumno extends Persona implements Serializable {
	private static final long serialVersionUID = 1L;


}
