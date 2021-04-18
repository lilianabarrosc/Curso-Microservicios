package com.lbarros.microservicio.matricula.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lbarros.microservicio.matricula.model.Profesor;

public interface ProfesorRepository extends JpaRepository<Profesor,Integer> {
	
}
