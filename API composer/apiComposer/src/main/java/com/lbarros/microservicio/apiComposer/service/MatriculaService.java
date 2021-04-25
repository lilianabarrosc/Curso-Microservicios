package com.lbarros.microservicio.apiComposer.service;

import java.util.List;

import com.lbarros.microservicio.apiComposer.model.Matricula;

public interface MatriculaService {
	
	List<Matricula> obtenerMatricula(String id);
}
