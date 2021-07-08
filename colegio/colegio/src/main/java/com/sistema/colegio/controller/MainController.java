package com.sistema.colegio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class MainController {
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/administrador")
	public String irAdministrador() {
		return "administrador";
	}
	
	@GetMapping("/agregarAlumno")
	public String addAlumno() {
		return "agregarAlumno";
	}
	
	
	
	
	

}
