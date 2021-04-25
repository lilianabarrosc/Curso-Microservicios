package com.lbarros.microservicio.apiComposer.composer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lbarros.microservicio.apiComposer.model.Alumno;
import com.lbarros.microservicio.apiComposer.model.Matricula;
import com.lbarros.microservicio.apiComposer.model.MatriculaAlumno;
import com.lbarros.microservicio.apiComposer.service.AlumnoService;
import com.lbarros.microservicio.apiComposer.service.MatriculaService;

@Component
public class MatriculaComposer {

	@Autowired
	private AlumnoService alumnoService;
	
	@Autowired
	private MatriculaService matriculaService;
	
	public List<MatriculaAlumno> parserMatricula(String id) {
		List<Matricula> matriculaList = matriculaService.obtenerMatricula(id);
		List<MatriculaAlumno> matriculaAlumnoList = new ArrayList<MatriculaAlumno>();
		
		for(Matricula matricula : matriculaList) {
			MatriculaAlumno matriculaAlumno = new MatriculaAlumno();
			matriculaAlumno.setMatricula(matricula);
		
			Alumno alumno = alumnoService.getAlumno(matricula.getCodMatricula().getIdentificacionAlumno()).get();
			
			matriculaAlumno.setAlumno(alumno);
			
			matriculaAlumnoList.add(matriculaAlumno);
		}
		
		return matriculaAlumnoList;
	}
}
