package com.lbarros.microservicio.apiComposer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.lbarros.microservicio.apiComposer.composer.MatriculaComposer;
import com.lbarros.microservicio.apiComposer.model.MatriculaAlumno;

@RestController
public class ComposerController {

	@Autowired
	private MatriculaComposer matriculaComposer;
	
	@GetMapping("/matricula/alumno/{id}")
	public List<MatriculaAlumno> getMatriculaAlumno(@PathVariable String alumno){
		return matriculaComposer.parserMatricula(alumno);
	}
}
