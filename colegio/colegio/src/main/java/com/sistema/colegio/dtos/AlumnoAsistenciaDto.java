package com.sistema.colegio.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlumnoAsistenciaDto {

	private Long alumnoId;
	private String alumnoNombre;
	private Boolean asistio=true;
	
	public AlumnoAsistenciaDto(Long alumnoId, String alumnoNombre) {
		this.alumnoId = alumnoId;
		this.alumnoNombre = alumnoNombre;
	}
	
	public AlumnoAsistenciaDto() {
		// TODO Auto-generated constructor stub
	}
	

	

}
