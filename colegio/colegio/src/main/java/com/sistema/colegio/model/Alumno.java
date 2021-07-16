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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

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
	
	@ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "alumno_curso",
            joinColumns = {@JoinColumn(name = "alumno_id")},
            inverseJoinColumns = {@JoinColumn(name = "curso_id")}
    )
	private List<Curso> cursos = new ArrayList<Curso>();
	
}
