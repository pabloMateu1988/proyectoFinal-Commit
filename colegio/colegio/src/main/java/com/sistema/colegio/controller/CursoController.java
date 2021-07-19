package com.sistema.colegio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sistema.colegio.service.CursoService;
import com.sistema.colegio.service.DocenteService;
@Controller
@RequestMapping("/cursoDocente")
public class CursoController {
	@Autowired
	private CursoService cursoService;
	@Autowired
	private DocenteService docenteService;
	
	@GetMapping("/verCursos/{idCurso}/{idDocente}")
	public String curso(Model model, @PathVariable("idCurso") Long id,@PathVariable("idDocente") Long idDocente) {
		model.addAttribute("tituloPrincipal","Bienvenido a");
		model.addAttribute("tituloListaAlumnos","Lista de Alumnos");
		model.addAttribute("tituloListaMaterias","Lista de Materias");
		model.addAttribute("curso", cursoService.buscarCursoPorId(id));
		model.addAttribute("docente", docenteService.buscarPorId(idDocente));
		return "cursoDocente";
		
		
	}
	
	@GetMapping("/verCursos/materia/{idCurso}/{idDocente}")
	public String materia(Model model, @PathVariable("idCurso") Long id,@PathVariable("idDocente") Long idDocente ) {
		model.addAttribute("curso", cursoService.buscarCursoPorId(id));
		model.addAttribute("docente", docenteService.buscarPorId(idDocente));
		return "cursoDocente";
		
		
	}

}

