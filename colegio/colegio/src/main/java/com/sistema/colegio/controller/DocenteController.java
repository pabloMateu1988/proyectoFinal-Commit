package com.sistema.colegio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sistema.colegio.repository.DocenteRepository;
import com.sistema.colegio.service.CursoService;
import com.sistema.colegio.service.DocenteService;

@Controller
@RequestMapping("/docente")
public class DocenteController {
	
	@Autowired
	CursoService cursoService;
	@Autowired
	DocenteService docenteService;
	@Autowired
	DocenteRepository docenteRepository;
	
	@GetMapping("/{id}")
	public String listar(Model model, @PathVariable("id") Long id) {
		model.addAttribute("titulo", "Bienvenido");
		model.addAttribute("tituloSecundario", "Cursos a cargo");
		model.addAttribute("docente", docenteService.buscarPorId(id));
		return "docente";
	}
	
	
	

}