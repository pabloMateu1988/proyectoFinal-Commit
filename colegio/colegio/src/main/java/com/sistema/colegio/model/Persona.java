package com.sistema.colegio.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public abstract class Persona implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private Long dni=33954643l;
	private String domicilio ="5 999";
	private String fechaDeNacimiento="29/12/1988";
	private String legajo="0/0001";
	private Long telefono=2216234423l;
	private String email="admin@hotmail.com";
	private String password;
}
