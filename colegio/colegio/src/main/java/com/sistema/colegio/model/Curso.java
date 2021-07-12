package com.sistema.colegio.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
public class Curso implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	
	@ManyToMany
	private List<Materia> materias = new ArrayList<Materia>();
	@ManyToMany
	private List<Docente> docentes = new ArrayList<Docente>();
	@ManyToMany
	private List<Alumno> alumnos = new ArrayList<>();
	
	public Curso() {
		
	}
	
	
	
	
	public Curso(Long id, String nombre, List<Materia> materias, List<Docente> docentes, List<Alumno> alumnos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.materias = materias;
		this.docentes = docentes;
		this.alumnos = alumnos;
	}




	public Long getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public List<Materia> getMaterias() {
		return materias;
	}
	public List<Docente> getDocentes() {
		return docentes;
	}
	public List<Alumno> getAlumnos() {
		return alumnos;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}
	public void setDocentes(List<Docente> docentes) {
		this.docentes = docentes;
	}
	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}




	@Override
	public String toString() {
		return "Curso [id=" + id + ", nombre=" + nombre + ", materias=" + materias + ", docentes=" + docentes
				+ ", alumnos=" + alumnos + "]";
	}


	
	
	

}
