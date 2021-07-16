package com.sistema.colegio.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

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
	
	@ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "docente_materia",
            joinColumns = {@JoinColumn(name = "docente_id")},
            inverseJoinColumns = {@JoinColumn(name = "materia_id")}
    )
	private List<Materia> materias = new ArrayList<Materia>();
	@ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "docente_curso",
            joinColumns = {@JoinColumn(name = "docente_id")},
            inverseJoinColumns = {@JoinColumn(name = "curso_id")}
    )
	private List<Curso> cursos = new ArrayList<Curso>();

	



	
	
	
	

	
	


}
