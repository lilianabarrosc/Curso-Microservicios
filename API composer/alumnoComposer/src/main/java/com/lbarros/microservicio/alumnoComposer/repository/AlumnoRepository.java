package com.lbarros.microservicio.alumnoComposer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lbarros.microservicio.alumnoComposer.model.Alumno;

public interface AlumnoRepository extends MongoRepository<Alumno, String> {

}
