package com.sistema.colegio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sistema.colegio.model.Materia;

@Service
public interface MateriaService {
	
	public List<Materia> listarMaterias();
	public void guardar(Materia materia);
	public Materia buscarPorId(Long id);
	public void eliminar(Long id);

}
