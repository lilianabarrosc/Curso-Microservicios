package com.lbarros.microservicio.apiComposer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lbarros.microservicio.apiComposer.clients.AlumnoFeignClient;
import com.lbarros.microservicio.apiComposer.model.Alumno;

@Service
public class AlumnoServiceImp implements AlumnoService {
	
	@Autowired
	private AlumnoFeignClient alumnoFeignClient;

	@Override
	public Optional<Alumno> getAlumno(String id) {
		return alumnoFeignClient.getAlumno(id);
	}

}
