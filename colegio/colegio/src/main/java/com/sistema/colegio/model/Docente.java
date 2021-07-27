package com.sistema.colegio.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.sun.istack.NotNull;

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
	
	@OneToMany
	List<Curso> cursos = new ArrayList<>();

	



	
	
	
	

	
	


}
