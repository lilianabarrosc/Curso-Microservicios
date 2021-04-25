package com.lbarros.microservicio.apiComposer.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.lbarros.microservicio.apiComposer.model.Matricula;

@FeignClient(name = "matricula-composer")
public interface MatriculaFeignClient {
	
	@GetMapping("/matricula/alumno/{id}")
	public List<Matricula> getMatricula(@PathVariable String id);
}
