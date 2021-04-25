package com.lbarros.microservicio.matriculaComposer.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.lbarros.microservicio.matriculaComposer.model.Alumno;
import com.lbarros.microservicio.matriculaComposer.model.Asignatura;
import com.lbarros.microservicio.matriculaComposer.model.Matricula;
import com.lbarros.microservicio.matriculaComposer.model.PeriodoEscolar;
import com.lbarros.microservicio.matriculaComposer.repository.AsignaturaRepository;
import com.lbarros.microservicio.matriculaComposer.repository.MatriculaRepository;
import com.lbarros.microservicio.matriculaComposer.repository.PeriodoEscolarRepository;
import com.netflix.discovery.EurekaClient;

@RestController
@CrossOrigin(origins = "*")
public class MatriculaController {

	@Autowired
	private EurekaClient eureka;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private MatriculaRepository matriculaRepository;
	
	@Autowired
	private AsignaturaRepository asignaturaRepository;
	
	@Autowired
	private PeriodoEscolarRepository periodoEscolarRepository;
	
	/*TODO moverlo a una clase de configuracion*/
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@GetMapping(value = "/healthMatricula", produces = "application/json; charset=utf-8")
	public String getHealthCheck()
	{
		return "{ \"todoOk\" : true }";
	}
	
	@GetMapping("/matriculas")
	public List<Matricula> getAlumnos()
	{
		return matriculaRepository.findAll();
	}
	
	@GetMapping("/matricula/alumno/{id}")
	public List<Matricula> getMatriculasAlumno(@PathVariable String identificacionUser)
	{
		return matriculaRepository.obtenerMatriculasAlumno(identificacionUser);
	}
	
	@GetMapping("/asignaturas")
	public List<Asignatura> getAasignaturas()
	{
		return asignaturaRepository.findAll();
	}
	
	@RequestMapping(value = "/matricula/{idAsinatura}", method = RequestMethod.POST)
	public void addMatriculaAlumno(@RequestBody Alumno alumno, @PathVariable Long idAsignatura)
	{
		Optional<Asignatura> asignatura = asignaturaRepository.findById(idAsignatura.intValue());
		
		//TODO by defaul, se deberia obtener el periodo actual
		Optional<PeriodoEscolar> periodo = periodoEscolarRepository.findById(1);
		
		Matricula matricula = new Matricula();
		matricula.setIdAsignatura(asignatura.get());
		matricula.setIdPeriodoEscolar(periodo.get()); 
		matricula.setIdentificacionAlumno(alumno.getNumeroIdentificacion() +  (!alumno.getDv().isEmpty()? alumno.getDv() : ""));
		matricula.setNombreAlumno(alumno.getNombre() + " " + alumno.getApellidoPat() + " " + alumno.getApellidoMat());
		
		matriculaRepository.save(matricula);
	}
}
