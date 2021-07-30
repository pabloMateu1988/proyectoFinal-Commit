package com.sistema.colegio.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlumnoDto {
	private Long id;
	private String nombre;
	
	public AlumnoDto(Long id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
	
	

}
