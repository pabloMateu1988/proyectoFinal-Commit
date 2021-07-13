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
import com.sistema.colegio.model.Curso;
import com.sistema.colegio.model.Docente;
import com.sistema.colegio.model.Materia;
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
	
	@GetMapping("/alumnos/crear")
	public String crearAlumno(Model model) {
		model.addAttribute("tituloTabla", "Lista de Alumnos");
		model.addAttribute("alumnos", alumnoService.listarAlumnos());
		model.addAttribute("tituloPrincipal", "Crear Alumno");
		model.addAttribute("cursos", cursoService.listarCursos());
		model.addAttribute("alumno", new Alumno());
		
		return "agregarAlumno";
		
		
	}
	@PostMapping("/alumnos/guardar")
	public String guardarAlumno(@ModelAttribute Alumno alumno) {
		alumnoService.guardar(alumno);
		System.out.println("Alumno guardado con exito");
		return "redirect:/administrador/alumnos/crear";
	}
	
	@GetMapping("/alumnos/eliminar/{id}")
	public String eliminarAlumno(@PathVariable("id") Long id) {
		alumnoService.eliminar(id);
		System.out.println("Eliminado con exito");
		return "redirect:/administrador/alumnos/crear";
		
	}
	@GetMapping("/alumnos/editar/{id}")
	public String editarAlumno(Model model, @PathVariable Long id) {
		model.addAttribute("tituloPrincipal", "Editar alumno");
		model.addAttribute("alumno", alumnoService.buscarAlumnoPorId(id));
		model.addAttribute("cursos", cursoService.listarCursos());
		System.out.println("Editado con exito");
		return "agregarAlumno";
	}
	
	@GetMapping("/docentes/crear")
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
	@PostMapping("/docentes/guardar")
	public String guardarDocente(@ModelAttribute Docente docente) {
		docenteService.guardar(docente);
		System.out.println("Docente guardado con exito");
		return "redirect:/administrador/docentes/crear";
	}
	
	@GetMapping("/docentes/eliminar/{id}")
	public String eliminarDocente(@PathVariable("id") Long id) {
		docenteService.eliminar(id);
		System.out.println("Eliminado con exito");
		return "redirect:/administrador/docentes/crear";
		
	}
	@GetMapping("/docentes/editar/{id}")
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
	
	@GetMapping("/materias/crear")
	public String crearMateria(Model model) {
		model.addAttribute("tituloPrincipal", "Crear Materia");
		model.addAttribute("tituloLista", "Lista Materia");
		model.addAttribute("materia", new Materia());
		model.addAttribute("materias", materiaService.listarMaterias());
		model.addAttribute("cursos", cursoService.listarCursos());
		
		return "agregarMaterias";
		
	}
	
	
	@PostMapping("/materias/guardar")
	public String guardarMateria(@ModelAttribute Materia materia) {
		materiaService.guardar(materia);
		return "redirect:/administrador/materias/crear";
		
	}
	
	@GetMapping("/materias/eliminar/{id}")
	public String eliminarMateria(@PathVariable("id") Long id) {
		materiaService.eliminar(id);
		System.out.println("Eliminado con exito");
		return "redirect:/administrador/materias/crear";
		
	}
	@GetMapping("/materias/editar/{id}")
	public String editarMateria(Model model, @PathVariable Long id) {
		Materia materia = materiaService.buscarPorId(id);
		model.addAttribute("titulo", "Editar Materia");
		model.addAttribute("materia", materia);
		model.addAttribute("materias", materiaService.listarMaterias());
		model.addAttribute("cursos", cursoService.listarCursos());
		System.out.println("Editado con exito");
		return "agregarMaterias";
	}
	
	@GetMapping("/cursos/crear")
	public String crearCurso(Model model) {
		model.addAttribute("titulo", "Lista de Cursos");
		model.addAttribute("cursos", cursoService.listarCursos());
		model.addAttribute("materias", materiaService.listarMaterias());
		model.addAttribute("tituloPrincipal", "Crear Curso");
		model.addAttribute("curso", new Curso());
		return "agregarCurso";
	}
	@PostMapping("/cursos/guardar")
	public String guardarCurso(@ModelAttribute Curso curso) {
		cursoService.guardar(curso);
		System.out.println("Curso guardado con exito");
		return "redirect:/administrador/cursos/crear";
	}
	@GetMapping("/cursos/eliminar/{id}")
	public String eliminarCurso(@PathVariable("id") Long id) {
		cursoService.eliminar(id);
		System.out.println("Eliminado con exito");
		return "redirect:/administrador/cursos/crear";
		
	}
	@GetMapping("/cursos/editar/{id}")
	public String editarCurso(Model model, @PathVariable Long id) {
		Curso curso = cursoService.buscarCursoPorId(id);
		model.addAttribute("titulo", "Editar cursos");
		model.addAttribute("curso", curso);
		model.addAttribute("cursos", cursoService.listarCursos());
		model.addAttribute("materias", materiaService.listarMaterias());
		System.out.println("Editado con exito");
		return "agregarCurso";
	}

	

}
