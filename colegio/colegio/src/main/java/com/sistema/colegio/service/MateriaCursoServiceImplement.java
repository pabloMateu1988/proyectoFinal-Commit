package com.sistema.colegio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.colegio.model.Docente;
import com.sistema.colegio.model.MateriaCurso;
import com.sistema.colegio.repository.CursoRepository;
import com.sistema.colegio.repository.DocenteRepository;
import com.sistema.colegio.repository.MateriaCursoRepository;
@Service
public class MateriaCursoServiceImplement implements MateriaCursoService {
	
	@Autowired
	MateriaCursoRepository materiaCursoRepository;
	@Autowired
	DocenteRepository docenteRepository;
	@Autowired
	CursoRepository cursoRepository;

	@Override
	public List<MateriaCurso> listarMateriasCurso() {
		return materiaCursoRepository.findAll();
	}

	@Override
	public void guardar(MateriaCurso materiaCurso) {
		materiaCursoRepository.saveAndFlush(materiaCurso);

	}

	@Override
	public MateriaCurso buscarPorId(Long id) {
		return materiaCursoRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Long id) {
		materiaCursoRepository.deleteById(id);

	}

	@Override
	public Docente buscarDocentePorId(Long id) {
		Optional<Docente> docente = docenteRepository.findById(id);
		return docente.get();
	}

}
