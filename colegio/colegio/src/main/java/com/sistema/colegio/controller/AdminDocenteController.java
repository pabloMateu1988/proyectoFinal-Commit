package com.sistema.colegio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sistema.colegio.model.Docente;
import com.sistema.colegio.service.CursoService;
import com.sistema.colegio.service.DocenteService;
import com.sistema.colegio.service.MateriaService;
@Controller
@RequestMapping("/docentes")
public class AdminDocenteController {
	
	@Autowired
	private DocenteService docenteService;
	@Autowired
	private CursoService cursoService;
	@Autowired
	private MateriaService materiaService;
	

	
	@GetMapping("/crear")
	public String crearDocente(Model model) {
		model.addAttribute("titulo", "Lista de Docentes");
		model.addAttribute("docentes", docenteService.listarDocentes());
		Docente d = new Docente();
		model.addAttribute("tituloPrincipal", "Crear Docente");
		model.addAttribute("cursos", cursoService.listarCursos());
		model.addAttribute("materias", materiaService.listarMaterias());
		model.addAttribute("docente", d);
		
		return "agregarDocente";
		
		
	}
	@PostMapping("/guardar")
	public String guardarDocente(@ModelAttribute Docente docente) {
		docenteService.guardar(docente);
		System.out.println("Docente guardado con exito");
		return "redirect:/docentes/crear";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarDocente(@PathVariable("id") Long id) {
		docenteService.eliminar(id);
		System.out.println("Eliminado con exito");
		return "redirect:/docentes/crear";
		
	}
	@GetMapping("/editar/{id}")
	public String editarDocente(Model model, @PathVariable Long id) {
		Docente docente = docenteService.buscarPorId(id);
		model.addAttribute("titulo", "Editar docentes");
		model.addAttribute("docente", docente);
		model.addAttribute("docentes", docenteService.listarDocentes());
		model.addAttribute("cursos", cursoService.listarCursos());
		model.addAttribute("materias", materiaService.listarMaterias());
		System.out.println("Editado con exito");
		return "agregarDocente";
	}

}
