package com.sistema.colegio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.colegio.model.Materia;
import com.sistema.colegio.repository.MateriaRepository;

@Service
public class MateriaServiceImplement implements MateriaService {
	@Autowired
	private MateriaRepository materiaRepository;

	@Override
	public List<Materia> listarMaterias() {
	
		return materiaRepository.findAll();
	}

	@Override
	public void guardar(Materia materia) {
		materiaRepository.save(materia);

	}

	@Override
	public Materia buscarPorId(Long id) {
		return materiaRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Long id) {
		materiaRepository.deleteById(id);

	}

}
