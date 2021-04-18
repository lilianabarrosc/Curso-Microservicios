package com.lbarros.microservicio.matricula.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lbarros.microservicio.matricula.model.Matricula;

public interface MatriculaRepository extends JpaRepository<Matricula,Integer>{

}
