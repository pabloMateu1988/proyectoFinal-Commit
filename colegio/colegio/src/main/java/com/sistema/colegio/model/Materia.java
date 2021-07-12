package com.sistema.colegio.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
public class Materia implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	
	@ManyToMany
	@JoinTable(name = "materia_cursos",joinColumns = @JoinColumn(name = "materia_id"),inverseJoinColumns =  @JoinColumn( name="cursos_id"))
	private List<Curso> cursos = new ArrayList<Curso>();;
	@ManyToMany
	private List<Alumno> alumnos = new ArrayList<Alumno>();
	@ManyToMany
	private List<Docente> docentes = new ArrayList<Docente>();
	
	public Materia() {
		
	}
	
	public Materia(Long id, String nombre, List<Curso> cursos, List<Alumno> alumnos, List<Docente> docentes) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cursos = cursos;
		this.alumnos = alumnos;
		this.docentes = docentes;
	}
	
	public Long getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public List<Curso> getCursos() {
		return cursos;
	}
	public List<Alumno> getAlumnos() {
		return alumnos;
	}
	public List<Docente> getDocentes() {
		return docentes;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	public void setDocentes(List<Docente> docentes) {
		this.docentes = docentes;
	}
	@Override
	public String toString() {
		return "Materia [id=" + id + ", nombre=" + nombre + ", cursos=" + cursos + ", alumnos=" + alumnos
				+ ", docentes=" + docentes + "]";
	}
	
	
	
	
	

}
