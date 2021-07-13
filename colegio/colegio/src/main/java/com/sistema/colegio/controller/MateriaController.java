package com.sistema.colegio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sistema.colegio.model.Materia;
import com.sistema.colegio.repository.CursoRepository;
import com.sistema.colegio.repository.MateriaRepository;
import com.sistema.colegio.service.CursoService;
import com.sistema.colegio.service.MateriaService;

@Controller
@RequestMapping("/materias")
public class MateriaController {
	@Autowired
	private MateriaService materiaService;
	@Autowired
	private CursoService cursoService;
	@Autowired
	private MateriaRepository materiaRepository;
	@Autowired
	private CursoRepository cursoRepository;
	
	
	
	
	
	

}
