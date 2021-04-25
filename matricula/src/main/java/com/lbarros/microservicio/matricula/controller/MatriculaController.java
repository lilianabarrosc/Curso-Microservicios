package com.lbarros.microservicio.matricula.controller;

import java.net.URI;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.lbarros.microservicio.matricula.client.EurekaClient;
import com.lbarros.microservicio.matricula.model.Alumno;
import com.lbarros.microservicio.matricula.model.Asignatura;
import com.lbarros.microservicio.matricula.model.Matricula;
import com.lbarros.microservicio.matricula.model.PeriodoEscolar;
import com.lbarros.microservicio.matricula.repository.AsignaturaRepository;
import com.lbarros.microservicio.matricula.repository.MatriculaRepository;
import com.lbarros.microservicio.matricula.repository.PeriodoEscolarRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

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
	
	@HystrixCommand(fallbackMethod = "fallbackMethod")
	@GetMapping("/alumno/{id}")
	public Alumno getAlumno(@PathVariable String id, @RequestHeader("Authorization") String auth)
	{
		//Encabezado de Authentication
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization",auth);
		HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
				
		URI uri = eureka.getUri("SERVICIO-ALUMNOS");
		System.out.println("url-->" + uri.getPath());
		//Alumno prod = null;
		ResponseEntity<Alumno> alumno = null;
		try {
			//prod = restTemplate.getForObject(URI.resolve("/alumno/"+id), Alumno.class);
			alumno = restTemplate.exchange(uri.resolve("/alumno/"+id), 
					HttpMethod.GET, entity, Alumno.class);
		}catch (Exception e) {
			System.out.println("error--> " + e);
		}
		
		return alumno.getBody();
	}
	
	private Alumno fallbackMethod(String codigo, String auth) {
		//tracer.currentSpan().tag("error", "No esta disponible alumnos");
		Date fecha = new Date(12,12,2000);
		return new Alumno("dfretewqew", 11111111L, "1", "Alumno1", "Apellido1", "Apellido2",
				"Ciudad1", "Direccion1", "12344546", fecha);
	}
	
}
