package com.lbarros.microservicio.apiComposer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lbarros.microservicio.apiComposer.clients.MatriculaFeignClient;
import com.lbarros.microservicio.apiComposer.model.Matricula;

@Service
public class MatriculaServiceImp implements MatriculaService {
	
	@Autowired
	private MatriculaFeignClient matriculaFeignClient;

	@Override
	public List<Matricula> obtenerMatricula(String id) {
		return matriculaFeignClient.getMatricula(id);
	}
}
