package com.sistema.colegio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.colegio.model.Asistencia;
import com.sistema.colegio.repository.AsistenciaRepository;
@Service
public class AsistenciaServiceImplement implements AsistenciaService {
	@Autowired
	private AsistenciaRepository asistenciaRepository;
	

	@Override
	public List<Asistencia> listarAsistencia() {
		return asistenciaRepository.findAll();
	}

	@Override
	public void guardarAsistencia(Asistencia asistencia) {
		asistenciaRepository.save(asistencia);

	}

	@Override
	public Asistencia buscarAsistenciaPorId(Long id) {
		return asistenciaRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub

	}



}
