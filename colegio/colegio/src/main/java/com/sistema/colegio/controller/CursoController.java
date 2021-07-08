package com.sistema.colegio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sistema.colegio.model.Curso;
import com.sistema.colegio.service.CursoService;

@Controller
@RequestMapping("/cursos")
public class CursoController {
	
	@Autowired
	private CursoService cursoService;
	
	@GetMapping("/nuevo")
	public String nuevoCurso(Model model) {
		model.addAttribute("curso", new Curso());
		model.addAttribute("titulo", "Lista de Cursos");
		model.addAttribute("cursos", cursoService.listarCursos());
		return "agregarCurso";
	}
	@PostMapping("/crear")
	public String guardarCurso(@ModelAttribute Curso curso) {
		cursoService.guardar(curso);
		System.out.println("Curso guardado con exito");
		return "redirect:/cursos/nuevo";
	}
	@GetMapping("/eliminar/{id}")
	public String eliminarCurso(@PathVariable("id") Long id) {
		cursoService.eliminar(id);
		System.out.println("Eliminado con exito");
		return "redirect:/cursos/nuevo";
		
	}

}
