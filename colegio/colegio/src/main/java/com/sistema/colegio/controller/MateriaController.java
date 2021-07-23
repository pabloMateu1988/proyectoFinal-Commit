package com.sistema.colegio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sistema.colegio.model.Asistencia;
import com.sistema.colegio.model.Materia;
import com.sistema.colegio.repository.CursoRepository;
import com.sistema.colegio.repository.MateriaRepository;
import com.sistema.colegio.service.AlumnoService;
import com.sistema.colegio.service.AsistenciaService;
import com.sistema.colegio.service.CursoService;
import com.sistema.colegio.service.MateriaService;

@Controller
@RequestMapping("/materia")
public class MateriaController {
	
	@Autowired
	private MateriaService materiaService;
	@Autowired
	private CursoService cursoService;
	@Autowired
	private AsistenciaService asistenciaService;
	@Autowired
	private AlumnoService alumnoService;
	
	
	@GetMapping("/{idMateria}/{idCurso}")
	public String materia(Model model, @PathVariable("idMateria") Long idMateria, @PathVariable("idCurso") Long idCurso) {
		model.addAttribute("materia", materiaService.buscarPorId(idMateria));
		model.addAttribute("curso", cursoService.buscarCursoPorId(idCurso));
		return "materiaDocente";
		
		
	}

	
	@GetMapping("/lista/crear/{idMateria}/{idCurso}")
	public String crearAsistencia(Model model, @PathVariable("idMateria") Long idMateria, @PathVariable("idCurso") Long idCurso) {
		model.addAttribute("asistencia", new Asistencia());
		model.addAttribute("tituloPrincipal", "Registro de Asistencia");
		model.addAttribute("materia", materiaService.buscarPorId(idMateria));
		model.addAttribute("curso", cursoService.buscarCursoPorId(idCurso));
		model.addAttribute("alumnos", alumnoService.listarAlumnos());
		
		return "asistencia";
		
		
	}
	
	@PostMapping("/lista/guardar")
	public String guardarAsistencia(@ModelAttribute Asistencia asistencia) {
		asistenciaService.guardarAsistencia(asistencia);
		System.out.println("Asistencia guardada con exito");
		return "redirect:/materia/lista/crear";
	}
	
	
	

}
