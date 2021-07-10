package com.sistema.colegio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.colegio.model.Docente;
import com.sistema.colegio.repository.DocenteRepository;
@Service
public class DocenteServiceImplement implements DocenteService {
	
	@Autowired
	private DocenteRepository docenteRepository;
	
	@Override
	public List<Docente> listarDocentes() {
		return docenteRepository.findAll();
	}

	@Override
	public void guardar(Docente docente) {
		docenteRepository.saveAndFlush(docente);
	}

	@Override
	public Docente buscarPorId(Long id) {
		return docenteRepository.findById(id).orElse(null);
		
	}

	@Override
	public void eliminar(Long id) {
		docenteRepository.deleteById(id);
	}

}
