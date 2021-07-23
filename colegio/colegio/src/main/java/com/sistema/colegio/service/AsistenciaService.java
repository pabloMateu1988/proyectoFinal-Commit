package com.sistema.colegio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sistema.colegio.model.Asistencia;
@Service
public interface AsistenciaService {
	
	public List<Asistencia> listarAsistencia();
	public void guardarAsistencia(Asistencia asistencia);
	public Asistencia buscarAsistenciaPorId(Long id);
	public void eliminar(Long id);

}
