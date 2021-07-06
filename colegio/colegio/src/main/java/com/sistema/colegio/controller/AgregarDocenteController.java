package com.sistema.colegio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sistema.colegio.model.Curso;
import com.sistema.colegio.model.Docente;
import com.sistema.colegio.service.CursoService;
import com.sistema.colegio.service.DocenteService;
@Controller
@RequestMapping
public class AgregarDocenteController {
	
	@Autowired
	private CursoService cursoService;
	private DocenteService docenteService;
	
	@GetMapping("/agregarDocente")
	public String crear(Model model) {
		List<Curso> listadoCursos = cursoService.listarCursos();
		
		Docente d = new Docente();
		model.addAttribute("titulo", "Nuevo Cliente");
		model.addAttribute("docente", d);
		model.addAttribute("curso", listadoCursos);
		
		return "agregarDocente";
		
		
	}
	@PostMapping("/agregarDocente")
	public String guardar(@ModelAttribute Docente docente) {
		docenteService.guardar(docente);
		System.out.println("Cliente guardado con exito");
		return "agregarDocente";
	}

}
