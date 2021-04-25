package com.lbarros.microservicio.apiComposer.model;

public class Matricula {
	
	 private MatriculaPK codMatricula;
	 private String nombreAlumno;
	 
	public MatriculaPK getCodMatricula() {
		return codMatricula;
	}
	public void setCodMatricula(MatriculaPK codMatricula) {
		this.codMatricula = codMatricula;
	}
	public String getNombreAlumno() {
		return nombreAlumno;
	}
	public void setNombreAlumno(String nombreAlumno) {
		this.nombreAlumno = nombreAlumno;
	}

}
