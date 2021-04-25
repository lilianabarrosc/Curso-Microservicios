package com.lbarros.microservicio.matriculaComposer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lbarros.microservicio.matriculaComposer.model.Matricula;
import com.lbarros.microservicio.matriculaComposer.model.MatriculaPK;

public interface MatriculaRepository extends JpaRepository<Matricula,MatriculaPK>{
	
	@Query(value = "SELECT * FROM Matricula M WHERE M.identificacion_alumno = ?", nativeQuery = true)
	public List<Matricula> obtenerMatriculasAlumno(String identificacion);
}
