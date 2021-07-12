package com.sistema.colegio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sistema.colegio.model.Curso;
import com.sistema.colegio.service.AlumnoService;
import com.sistema.colegio.service.CursoService;
import com.sistema.colegio.service.DocenteService;
import com.sistema.colegio.service.MateriaService;

@Controller
@RequestMapping("/administrador")
public class AdministradorController {
	@Autowired
	private CursoService cursoService;
	@Autowired
	private AlumnoService alumnoService;
	@Autowired
	private DocenteService docenteService;
	@Autowired
	private MateriaService materiaService;
	
	@GetMapping("/listar")
	public String listarCursos(Model model) {
		model.addAttribute("cursos", cursoService.listarCursos());
		model.addAttribute("docentes", docenteService.listarDocentes());
		
		return "administrador";
		
	}
	

}
