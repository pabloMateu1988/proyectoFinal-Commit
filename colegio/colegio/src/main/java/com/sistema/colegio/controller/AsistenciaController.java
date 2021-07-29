package com.sistema.colegio.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sistema.colegio.dtos.AlumnoAsistenciaDto;
import com.sistema.colegio.dtos.CursoDto;
import com.sistema.colegio.dtos.MateriaDto;
import com.sistema.colegio.dtos.PasarLista;
import com.sistema.colegio.model.Alumno;
import com.sistema.colegio.model.Asistencia;
import com.sistema.colegio.model.CursoAlumno;
import com.sistema.colegio.model.Materia;
import com.sistema.colegio.repository.CursoAlumnoRepository;
import com.sistema.colegio.service.CursoAlumnoService;
import com.sistema.colegio.service.CursoService;
import com.sistema.colegio.service.MateriaService;

@Controller
@RequestMapping("asistencia")
public class AsistenciaController {
	
	@Autowired
	CursoService cursoService;
	@Autowired
	MateriaService materiaService;
	@Autowired
	CursoAlumnoRepository cursoAlumnoRepository;
	
	@SuppressWarnings("unchecked")//Controlar esto
	@GetMapping("/{cursoId}/{materiaId}")
	public String controlarAsistencia(Model model,@PathVariable("cursoId") Long cursoId, @PathVariable("materiaId") Long materiaId) {
		
		CursoAlumno curso = (CursoAlumno) cursoAlumnoRepository.buscarCursoAlumno(cursoId);
		Materia materia = materiaService.buscarPorId(materiaId);
		List<Alumno> alumnos = (List<Alumno>) curso.getAlumno();
		
		CursoDto cursoDto = new CursoDto(curso.getCurso().getId(), curso.getCurso().getNombre());
		MateriaDto materiaDto = new MateriaDto(materia.getId(), materia.getNombre());
		
		
		
		alumnos.stream().map(a -> new AlumnoAsistenciaDto(a.getId(), a.getNombre())).collect(Collectors.toList());
		
		PasarLista pasarLista = new PasarLista(new Date(), materiaDto, cursoDto, alumnos);
		
		model.addAttribute("pasarLista", pasarLista);
		
		
		return "controlarAsistencia";
	}
	
	public String guardarControlAsistencia(@ModelAttribute PasarLista pasarLista) {
		Asistencia asistencia = new Asistencia();
		asistencia.setCurso(pasarLista.);
		asistencia.setFecha(null);
		asistencia.setAlumno(null);
		asistencia.setAsistio(null);
		return "controlAsistencia";
		
	}

}
