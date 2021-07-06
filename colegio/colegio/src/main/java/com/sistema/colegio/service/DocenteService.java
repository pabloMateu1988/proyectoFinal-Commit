package com.sistema.colegio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sistema.colegio.model.Docente;
@Service
public interface DocenteService {
	
	
	public List<Docente> listarTodos();
	public void guardar(Docente docente);
	public Docente buscar(Long id);
	public void eliminar(Long id);
		

}
