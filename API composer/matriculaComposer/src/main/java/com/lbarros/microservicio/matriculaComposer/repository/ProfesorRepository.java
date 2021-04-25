package com.lbarros.microservicio.matriculaComposer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lbarros.microservicio.matriculaComposer.model.Profesor;

public interface ProfesorRepository extends JpaRepository<Profesor,Integer> {
	
}
