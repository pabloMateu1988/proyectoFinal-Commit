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
public class AdminCursoController {
	
	@Autowired
	private CursoService cursoService;
	
	@GetMapping("/crear")
	public String crearCurso(Model model) {
		model.addAttribute("titulo", "Lista de Cursos");
		model.addAttribute("cursos", cursoService.listarCursos());
		model.addAttribute("tituloPrincipal", "Crear Curso");
		model.addAttribute("curso", new Curso());
		return "agregarCurso";
	}
	@PostMapping("/guardar")
	public String guardarCurso(@ModelAttribute Curso curso) {
		cursoService.guardar(curso);
		System.out.println("Curso guardado con exito");
		return "redirect:/cursos/crear";
	}
	@GetMapping("/eliminar/{id}")
	public String eliminarCurso(@PathVariable("id") Long id) {
		cursoService.eliminar(id);
		System.out.println("Eliminado con exito");
		return "redirect:/cursos/crear";
		
	}
	@GetMapping("/editar/{id}")
	public String editarCurso(Model model, @PathVariable Long id) {
		Curso curso = cursoService.buscarCursoPorId(id);
		model.addAttribute("titulo", "Editar cursos");
		model.addAttribute("curso", curso);
		model.addAttribute("cursos", cursoService.listarCursos());
		System.out.println("Editado con exito");
		return "agregarCurso";
	}

}
