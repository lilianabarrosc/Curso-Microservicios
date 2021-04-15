package com.lbarros.microservicio.alumnos.service;

import java.util.List;
import java.util.Optional;

import com.lbarros.microservicio.alumnos.model.Alumno;

public interface AlumnoService {
	Alumno guardarAlumno(Alumno alumno);
	
	String eliminarAlumno(String id);
	
	Optional<Alumno> actualizarAlumno(Alumno alumno, String id);
	
	Optional<Alumno> obtenerAlumno(String id);
	
	List<Alumno> listaAlumnos();
	
}
