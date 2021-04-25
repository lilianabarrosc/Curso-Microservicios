package com.lbarros.microservicio.apiComposer.service;

import java.util.Optional;

import com.lbarros.microservicio.apiComposer.model.Alumno;

public interface AlumnoService {
	
	Optional<Alumno> getAlumno(String id);
}
