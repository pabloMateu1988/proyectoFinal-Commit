package com.sistema.colegio.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue("Materia")
@Getter
@Setter
@NoArgsConstructor
public class Materia implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	
	@ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "materia_curso",
            joinColumns = {@JoinColumn(name = "materia_id")},
            inverseJoinColumns = {@JoinColumn(name = "curso_id")}
    )
	private List<Curso> cursos = new ArrayList<Curso>();
	@ManyToMany
	private List<Alumno> alumnos = new ArrayList<Alumno>();
	@ManyToMany(mappedBy = "materias")
	private List<Docente> docentes = new ArrayList<Docente>();

}
