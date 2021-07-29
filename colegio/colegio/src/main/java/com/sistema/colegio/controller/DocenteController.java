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
@RequestMapping("/docente")
public class DocenteController {
	
	@Autowired
	CursoService cursoService;
	@Autowired
	DocenteService docenteService;
	@Autowired
	MateriaCursoService materiaCursoService;
	@Autowired
	MateriaCursoRepository materiaCursoRepository;
	
	@GetMapping("/{id}")
	public String listar(Model model, @PathVariable("id") Long id) {
		model.addAttribute("titulo", "Bienvenido");
		model.addAttribute("tituloSecundario", "Cursos a cargo");
		model.addAttribute("docente", materiaCursoService.buscarDocentePorId(id));
		model.addAttribute("cursoDocente", materiaCursoRepository.buscarCursoDocente(id));
	
		return "docente";
	}
	
	
	

}