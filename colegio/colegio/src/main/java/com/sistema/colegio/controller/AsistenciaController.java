package com.sistema.colegio.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sistema.colegio.dtos.AlumnoAsistenciaDto;
import com.sistema.colegio.dtos.PasarLista;
import com.sistema.colegio.model.Alumno;
import com.sistema.colegio.model.Asistencia;
import com.sistema.colegio.model.Curso;
import com.sistema.colegio.model.CursoAlumno;
import com.sistema.colegio.model.Materia;
import com.sistema.colegio.repository.CursoAlumnoRepository;
import com.sistema.colegio.service.AsistenciaService;
import com.sistema.colegio.service.CursoAlumnoService;
import com.sistema.colegio.service.CursoService;
import com.sistema.colegio.service.MateriaService;

@Controller
@RequestMapping("/asistencia")
public class AsistenciaController {
	
	@Autowired
	CursoService cursoService;
	@Autowired
	MateriaService materiaService;
	@Autowired
	CursoAlumnoRepository cursoAlumnoRepository;
	@Autowired
	CursoAlumnoService cursoAlumnoService;
	@Autowired
	AsistenciaService asistenciaService;
	
	@GetMapping("/pasarLista/{cursoId}/{materiaId}")
	public String controlarAsistencia(Model model,@PathVariable("cursoId") Long cursoId, @PathVariable("materiaId") Long materiaId) {
		
		Curso curso = cursoService.buscarCursoPorId(cursoId);
		Materia materia = materiaService.buscarPorId(materiaId);
		List<CursoAlumno> alumno = cursoAlumnoRepository.buscarCursoAlumno(cursoId);
		model.addAttribute("curso", curso);
		model.addAttribute("materia", materia);
		model.addAttribute("alumnoCurso", alumno);
		model.addAttribute("tituloPrincipal", "Asistencia");

//		List<Alumno> alumnos = new ArrayList<Alumno>();
//		alumnos.add(curso.getAlumno());
//		
//		CursoDto cursoDto = new CursoDto(curso.getCurso().getId(), curso.getCurso().getNombre());
//		MateriaDto materiaDto = new MateriaDto(materia.getId(), materia.getNombre());
//		
//		
//		
		alumno.stream().map(a -> new AlumnoAsistenciaDto(a.getId(), a.getAlumno().getNombre())).collect(Collectors.toList());
		String fecha = "";	
		String observaciones ="";
		PasarLista pasarLista = new PasarLista(fecha, materia, curso, alumno, observaciones );
//		
		model.addAttribute("pasarLista", pasarLista);
		
		
		return "asistencia";
	}
	@PostMapping("/guardar")
	public String guardarControlAsistencia(Model model,@ModelAttribute PasarLista pasarLista) {
		Asistencia asistencia = new Asistencia();
		asistencia.setCurso(pasarLista.getCurso());
		asistencia.setFecha(pasarLista.getFecha());
		asistencia.setAlumno((Alumno) pasarLista.getAlumnos());
		asistencia.setAsistio(pasarLista.getAsistio());
		asistencia.setMateria(pasarLista.getMateria());
		asistencia.setObservaciones(pasarLista.getObservaciones());
		
		asistenciaService.guardarAsistencia(asistencia);
		return "redirect:/administrador/listar";
		
	}

}
