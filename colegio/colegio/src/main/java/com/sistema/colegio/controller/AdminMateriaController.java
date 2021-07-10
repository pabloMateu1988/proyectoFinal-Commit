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
import com.sistema.colegio.service.MateriaService;

@Controller
@RequestMapping("/materias")
public class AdminMateriaController {
	@Autowired
	private MateriaService materiaService;
	
	@GetMapping("/crear")
	public String crearMateria(Model model) {
		model.addAttribute("tituloPrincipal", "Crear Materia");
		model.addAttribute("tituloLista", "Lista Materia");
		model.addAttribute("materias", materiaService.listarMaterias());
		model.addAttribute("materia", new Materia());
		return "agregarMaterias";
		
	}
	
	
	@PostMapping("/guardar")
	public String guardarMateria(@ModelAttribute Materia materia) {
		materiaService.guardar(materia);
		return "redirect:/materias/crear";
		
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarMateria(@PathVariable("id") Long id) {
		materiaService.eliminar(id);
		System.out.println("Eliminado con exito");
		return "redirect:/docentes/crear";
		
	}
	@GetMapping("/editar/{id}")
	public String editarMateria(Model model, @PathVariable Long id) {
		Materia materia = materiaService.buscarPorId(id);
		model.addAttribute("titulo", "Editar Materia");
		model.addAttribute("materias", materia);
		model.addAttribute("materias", materiaService.listarMaterias());
		System.out.println("Editado con exito");
		return "agregarMateria";
	}
	

}
