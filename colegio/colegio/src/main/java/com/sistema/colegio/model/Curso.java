package com.sistema.colegio.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ConstraintMode;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "curso_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
	private List<Materia> materias = new ArrayList<Materia>();
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Docente> docentes = new ArrayList<Docente>();
	@ManyToMany
	private List<Alumno> alumnos = new ArrayList<>();



	
	
	

}
