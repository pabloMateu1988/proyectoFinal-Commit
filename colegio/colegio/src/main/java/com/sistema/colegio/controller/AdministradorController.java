package com.sistema.colegio.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sistema.colegio.model.Alumno;
import com.sistema.colegio.model.Curso;
import com.sistema.colegio.model.Docente;
import com.sistema.colegio.model.Materia;
import com.sistema.colegio.model.MateriaCurso;
import com.sistema.colegio.service.AlumnoService;
import com.sistema.colegio.service.CursoService;
import com.sistema.colegio.service.DocenteService;
import com.sistema.colegio.service.MateriaCursoService;
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
	@Autowired
	private MateriaCursoService materiaCursoService;
	
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
		model.addAttribute(new Alumno());
		
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
		model.addAttribute("tituloLista", "Lista de Docentes");
		model.addAttribute("docentes", docenteService.listarDocentes());
		model.addAttribute("tituloPrincipal", "Crear Docente");
		model.addAttribute("materias", materiaService.listarMaterias());
		model.addAttribute("cursos", cursoService.listarCursos());
		model.addAttribute("docente", new Docente());
		
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
	@GetMapping("/docentes/editarDocente/{id}")
	public String editarDocente(Model model, @PathVariable Long id) {
		Docente docente = docenteService.buscarPorId(id);
		model.addAttribute("titulo", "Editar docentes");
		model.addAttribute("docente", docente);
		model.addAttribute("docentes", docenteService.listarDocentes());
		model.addAttribute("cursos", cursoService.listarCursos());
		model.addAttribute("materias", materiaService.listarMaterias());
		System.out.println("Editado con exito");
		return "editarDocente";
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
	@GetMapping("/materias/editarMateria/{id}")
	public String editarMateria(Model model, @PathVariable Long id) {
		Materia materia = materiaService.buscarPorId(id);
		model.addAttribute("titulo", "Editar Materia");
		model.addAttribute("materia", materia);
		model.addAttribute("materias", materiaService.listarMaterias());
		model.addAttribute("cursos", cursoService.listarCursos());
		System.out.println("Editado con exito");
		return "editarMateria";
	}
	
	@GetMapping("/cursos/crear")
	public String crearCurso(Model model) {
		model.addAttribute("titulo", "Lista de Cursos");
		model.addAttribute("cursos", cursoService.listarCursos());
		model.addAttribute("materias", materiaService.listarMaterias());
		model.addAttribute("docentes", docenteService.listarDocentes());
		model.addAttribute("alumnos", alumnoService.listarAlumnos());
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
	@GetMapping("/cursos/editarCurso/{id}")
	public String editarCurso(Model model, @PathVariable Long id) {
		Curso curso = cursoService.buscarCursoPorId(id);
		model.addAttribute("titulo", "Editar cursos");
		model.addAttribute("curso", curso);
		model.addAttribute("cursos", cursoService.listarCursos());
		model.addAttribute("materias", materiaService.listarMaterias());
		model.addAttribute("docentes", docenteService.listarDocentes());
		model.addAttribute("alumnos", alumnoService.listarAlumnos());
		System.out.println("Editado con exito");
		return "editarCurso";
	}


	@GetMapping("/completaraula/crear")
	public String completarAula(Model model) {
		model.addAttribute("materiaCurso", new MateriaCurso());
		model.addAttribute("materias", materiaService.listarMaterias());
		model.addAttribute("cursos", cursoService.listarCursos());
		model.addAttribute("docentes", docenteService.listarDocentes());
		model.addAttribute("materiaCursos",materiaCursoService.listarMateriasCurso());
		return "completarAula";
	}

	
	@PostMapping("/completaraula/guardar")
	public String completarAula(@ModelAttribute("materiaCurso") MateriaCurso materiaCurso) {
		Curso curso = cursoService.buscarCursoPorId(materiaCurso.getCurso().getId());
		Materia materia = materiaService.buscarPorId(materiaCurso.getMateria().getId());
		Docente docente = docenteService.buscarPorId(materiaCurso.getDocente().getId());
		materiaCurso.setCurso(curso);
		materiaCurso.setDocente(docente);
		materiaCurso.setMateria(materia);
		//...
		materiaCursoService.guardar(materiaCurso);
		curso.getMaterias().add(materiaCurso);

		
		System.out.println("Aula completa guardada");
		return "redirect:/administrador/completaraula/crear";
	}
	
	@GetMapping("/completarAula/editarAula/{id}")
	public String editarAula(Model model, @PathVariable Long id) {
		MateriaCurso materiaCurso = (MateriaCurso) materiaCursoService.buscarPorId(id);
		model.addAttribute("titulo", "Editar cursos");
		model.addAttribute("materiaCurso", materiaCurso);
		model.addAttribute("materias", materiaService.listarMaterias());
		model.addAttribute("cursos", cursoService.listarCursos());
		model.addAttribute("docentes", docenteService.listarDocentes());
		System.out.println("Editado con exito");
		return "editarAula";
	}
	
	@GetMapping("/completarAula/eliminarAula/{id}")
	public String eliminarAula(Model model, @PathVariable Long id) {
		materiaCursoService.eliminar(id);
		return "redirect:/administrador/completaraula/crear";
	}
	
	@GetMapping("/completarAulaAlumnos/crear")
	public String completarAulaAlumnos(Model model) {
		model.addAttribute("curso", new Curso());
		model.addAttribute("materias", materiaService.listarMaterias());
		model.addAttribute("cursos", cursoService.listarCursos());
		model.addAttribute("alumnos",alumnoService.listarAlumnos());
		model.addAttribute("materiaCurso", materiaCursoService.listarMateriasCurso());
		return "completarAulaAlumnos";
	}

	
	@PostMapping("/completarAulaAlumnos/guardar")
	public String completarAlumnos(@ModelAttribute Curso curso) {
		curso.setId(curso.getId());
		curso.setNombre(curso.getNombre());
		cursoService.guardar(curso);
		System.out.println(curso);
		
		System.out.println("Aula completa con Alumnos");
		return "redirect:/administrador/completarAulaAlumnos/crear";
	}
	
}
