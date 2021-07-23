package com.sistema.colegio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sistema.colegio.model.Alumno;
import com.sistema.colegio.model.Asistencia;
import com.sistema.colegio.service.AlumnoService;
import com.sistema.colegio.service.AsistenciaService;
import com.sistema.colegio.service.CursoService;
import com.sistema.colegio.service.DocenteService;
import com.sistema.colegio.service.MateriaService;
@Controller
@RequestMapping("/cursoDocente")
public class CursoController {
	@Autowired
	private CursoService cursoService;
	@Autowired
	private DocenteService docenteService;
	@Autowired
	private MateriaService materiaService;
	@Autowired
	private AlumnoService alumnoService;
	
	@GetMapping("/verCursos/{idDocente}/{idCurso}")
	public String curso(Model model, @PathVariable("idCurso") Long id,@PathVariable("idDocente") Long idDocente) {
		model.addAttribute("tituloPrincipal","Bienvenido a");
		model.addAttribute("tituloListaAlumnos","Lista de Alumnos");
		model.addAttribute("tituloListaMaterias","Lista de Materias");
		model.addAttribute("curso", cursoService.buscarCursoPorId(id));
		model.addAttribute("docente", docenteService.buscarPorId(idDocente));
		
		return "cursoDocente";
		
		
	}
	
	

}

