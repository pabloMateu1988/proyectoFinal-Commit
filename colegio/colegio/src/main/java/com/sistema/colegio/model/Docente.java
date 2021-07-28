package com.sistema.colegio.model;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue("Docente")
@NoArgsConstructor
@Getter
@Setter
public class Docente extends Persona implements Serializable{
	private static final long serialVersionUID = 1L;
	
//	@OneToMany
//	List<Curso> cursos = new ArrayList<Curso>();

	



	
	
	
	

	
	


}
