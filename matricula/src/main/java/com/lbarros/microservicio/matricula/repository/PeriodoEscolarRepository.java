package com.lbarros.microservicio.matricula.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lbarros.microservicio.matricula.model.PeriodoEscolar;

public interface PeriodoEscolarRepository extends JpaRepository<PeriodoEscolar,Integer>{

}
