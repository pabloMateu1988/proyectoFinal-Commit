package com.sistema.colegio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sistema.colegio.model.Curso;
import com.sistema.colegio.service.CursoService;

@Controller
@RequestMapping
public class cursoController {
	
	@Autowired
	private CursoService cursoService;
	
	@GetMapping("/administrador")
	public String listarCursos(Model model) {
		List<Curso> listadoCursos = cursoService.listarCursos();
				
		model.addAttribute("titulo", "Lista de cursos");
		model.addAttribute("curso", listadoCursos);
		
		return "administrador";
	}

}
