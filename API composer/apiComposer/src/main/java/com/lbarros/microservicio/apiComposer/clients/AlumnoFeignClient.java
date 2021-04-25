package com.lbarros.microservicio.apiComposer.clients;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.lbarros.microservicio.apiComposer.model.Alumno;

@FeignClient(name = "alumno-composer")
public interface AlumnoFeignClient {

	@GetMapping("/alumno/{id}")
	public Optional<Alumno> getAlumno(@PathVariable String id);
}
