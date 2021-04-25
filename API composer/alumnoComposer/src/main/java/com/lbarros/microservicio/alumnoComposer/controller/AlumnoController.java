package com.lbarros.microservicio.alumnoComposer.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lbarros.microservicio.alumnoComposer.model.Alumno;
import com.lbarros.microservicio.alumnoComposer.service.AlumnoService;

@RestController
@CrossOrigin(origins = "*")
public class AlumnoController
{
	@Autowired
	AlumnoService productoService;

	@GetMapping(value = "/healthAlumnos", produces = "application/json; charset=utf-8")
	public String getHealthCheck()
	{
		return "{ \"todoOk\" : true }";
	}

	@GetMapping("/alumnos")
	public List<Alumno> getAlumnos()
	{
		return productoService.listaAlumnos();
	}

	@GetMapping("/alumno/{id}")
	public Optional<Alumno> getAlumno(@PathVariable String id)
	{
		return productoService.obtenerAlumno(id);
	}

	@PutMapping("/alumno/{id}")
	public Optional<Alumno> updateAlumno(@RequestBody Alumno alumno, @PathVariable String id)
	{
		return productoService.actualizarAlumno(alumno, id);
	}

	@DeleteMapping(value = "/alumno/{id}")
	public HttpEntity<String> deleteAlumno(@PathVariable String id) {
		String resultado = productoService.eliminarAlumno(id);
		return new HttpEntity<String>(resultado);
	}

	@PostMapping("/alumno")
	public Alumno addProducto(@RequestBody Alumno alumno)
	{
		return productoService.guardarAlumno(alumno);
	}
}
