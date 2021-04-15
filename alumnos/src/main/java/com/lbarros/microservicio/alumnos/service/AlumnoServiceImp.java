package com.lbarros.microservicio.alumnos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lbarros.microservicio.alumnos.model.Alumno;
import com.lbarros.microservicio.alumnos.repository.AlumnoRepository;

@Service
public class AlumnoServiceImp implements AlumnoService {

	@Autowired
	AlumnoRepository alumnoRepository;
	
	@Override
	public Alumno guardarAlumno(Alumno alumno) {
		return alumnoRepository.insert(alumno);
	}

	@Override
	public String eliminarAlumno(String id) {
		if(id != null) {
			Boolean result = alumnoRepository.existsById(id);
			if(result) {
				alumnoRepository.deleteById(id);
				return "Eliminado exitosamente";
			}
			return "Identificación de alumno no encontrada";
		}
		return "Proporcione un numero de identificación";	
	}

	@Override
	public Optional<Alumno> actualizarAlumno(Alumno alumno, String id) {
		Optional<Alumno> alumnos = alumnoRepository.findById(id);
		if (alumnos.isPresent()) {
			Alumno newAlumno = alumnos.get();
			newAlumno.setNombre(alumno.getNombre());
			newAlumno.setApellidoPat(alumno.getApellidoPat());
			newAlumno.setApellidoMat(alumno.getApellidoMat());
			newAlumno.setCiudad(alumno.getCiudad());
			newAlumno.setDirecion(alumno.getDirecion());
			newAlumno.setTelefono(alumno.getTelefono());
			newAlumno.setFechaNacimiento(alumno.getFechaNacimiento());
			alumnoRepository.save(newAlumno);
		}
		return alumnos;
	}

	@Override
	public Optional<Alumno> obtenerAlumno(String id) {

		Optional<Alumno> alumnos = alumnoRepository.findById(id);// One(example);

		return alumnos;
	}

	@Override
	public List<Alumno> listaAlumnos() {
		List<Alumno> alumnos = alumnoRepository.findAll();
		return alumnos;
	}
}
