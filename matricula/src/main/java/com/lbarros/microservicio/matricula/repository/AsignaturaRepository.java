package com.lbarros.microservicio.matricula.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lbarros.microservicio.matricula.model.Asignatura;

public interface AsignaturaRepository extends JpaRepository<Asignatura,Integer>{

}
