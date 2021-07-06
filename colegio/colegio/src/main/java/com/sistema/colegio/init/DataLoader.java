package com.sistema.colegio.init;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import com.sistema.colegio.model.Alumno;
import com.sistema.colegio.model.Curso;
import com.sistema.colegio.repository.AlumnoRepository;
import com.sistema.colegio.repository.CursoRepository;

public class DataLoader implements ApplicationRunner {
	
	private AlumnoRepository alumnoRepository;
	private CursoRepository cursoRepository;
	
	public DataLoader (AlumnoRepository alumnoRepository, CursoRepository cursoRepository) {
		this.alumnoRepository = alumnoRepository;
		this.cursoRepository = cursoRepository;
	}
	
	public void run(ApplicationArguments args) {
		Alumno a = new Alumno();
		a.setNombre("Pablo");
		alumnoRepository.save(a);
		
		Curso c = new Curso();
		c.setNombre("1A");
		cursoRepository.save(c);
		
	}

}
