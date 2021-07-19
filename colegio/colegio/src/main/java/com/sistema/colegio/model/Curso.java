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
import lombok.ToString;

@Entity
@DiscriminatorValue("Curso")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Curso implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private int anioCalendario=2021;
	
	@ManyToMany(cascade = {
            CascadeType.ALL
    })
    @JoinTable(
            name = "curso_materia",
            joinColumns = {@JoinColumn(name = "curso_id")},
            inverseJoinColumns = {@JoinColumn(name = "materia_id")}
    )
	private List<Materia> materias = new ArrayList<Materia>();
	@ManyToMany(cascade = {
            CascadeType.ALL
    })
    @JoinTable(
            name = "curso_docente",
            joinColumns = {@JoinColumn(name = "curso_id")},
            inverseJoinColumns = {@JoinColumn(name = "docente_id")}
    )
	private List<Docente> docentes = new ArrayList<Docente>();
	@ManyToMany(mappedBy = "cursos")
	private List<Alumno> alumnos = new ArrayList<>();



	
	
	

}
