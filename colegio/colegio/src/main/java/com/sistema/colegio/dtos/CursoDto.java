package com.sistema.colegio.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CursoDto {
	
	private Long id;
	private String nombre;
	
	public CursoDto(Long id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
	
	

}
