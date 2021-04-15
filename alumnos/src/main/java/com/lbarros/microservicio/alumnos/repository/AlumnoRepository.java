package com.lbarros.microservicio.alumnos.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.lbarros.microservicio.alumnos.model.Alumno;

public interface AlumnoRepository extends MongoRepository<Alumno, String> {

}
