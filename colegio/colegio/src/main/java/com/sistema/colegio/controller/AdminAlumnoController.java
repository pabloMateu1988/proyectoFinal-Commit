package com.sistema.colegio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sistema.colegio.model.Alumno;
import com.sistema.colegio.service.AlumnoService;
import com.sistema.colegio.service.CursoService;
@Controller
@RequestMapping("/alumnos")
public class AdminAlumnoController {
	
	@Autowired
	private AlumnoService alumnoService;
	@Autowired
	private CursoService cursoService;

	

	
	@GetMapping("/crear")
	public String crearDocente(Model model) {
		model.addAttribute("titulo", "Lista de Alumnos");
		model.addAttribute("alumnos", alumnoService.listarAlumnos());
		model.addAttribute("tituloPrincipal", "Crear Alumno");
		model.addAttribute("cursos", cursoService.listarCursos());
		model.addAttribute("alumno", new Alumno());
		
		return "agregarAlumno";
		
		
	}
	@PostMapping("/guardar")
	public String guardarDocente(@ModelAttribute Alumno alumno) {
		alumnoService.guardar(alumno);
		System.out.println("Alumno guardado con exito");
		return "redirect:/alumnos/crear";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarDocente(@PathVariable("id") Long id) {
		alumnoService.eliminar(id);
		System.out.println("Eliminado con exito");
		return "redirect:/alumnos/crear";
		
	}
	@GetMapping("/editar/{id}")
	public String editarDocente(Model model, @PathVariable Long id) {
		model.addAttribute("titulo", "Editar alumno");
		model.addAttribute("alumno", alumnoService.buscarAlumnoPorId(id));
		model.addAttribute("cursos", cursoService.listarCursos());
		System.out.println("Editado con exito");
		return "agregarAlumno";
	}

}

