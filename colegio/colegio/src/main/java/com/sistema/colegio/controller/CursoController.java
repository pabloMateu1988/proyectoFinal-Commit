package com.sistema.colegio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;

import com.sistema.colegio.repository.MateriaCursoRepository;
import com.sistema.colegio.service.CursoService;
import com.sistema.colegio.service.DocenteService;
import com.sistema.colegio.service.MateriaCursoService;
@Controller
@RequestMapping("/cursoDocente")
public class CursoController {
	@Autowired
	private CursoService cursoService;
	@Autowired
	private DocenteService docenteService;
	@Autowired
	MateriaCursoService materiaCursoService;
	@Autowired
	MateriaCursoRepository materiaCursoRepository;
	
	@GetMapping("/verCursos/{idDocente}/{idCurso}")
	public String curso(Model model, @PathVariable("idDocente") Long idDocente, @PathVariable("idCurso") Long idCurso) {
		model.addAttribute("tituloPrincipal","Bienvenido a");
		model.addAttribute("tituloListaAlumnos","Lista de Alumnos");
		model.addAttribute("tituloListaMaterias","Lista de Materias");
		model.addAttribute("docente", docenteService.buscarPorId(idDocente));
		
		return "cursoDocente";
		
		
	}
	
	

}

