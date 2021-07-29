package com.sistema.colegio.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MateriaDto {
	
	private Long id;
	private String nombre;
	
	public MateriaDto(Long id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
	
	

}
