package com.lbarros.microservicio.matriculaComposer.model;

import javax.persistence.Embeddable;

@Embeddable
public class MatriculaPK {

	private Long idAsignatura;
	private Long idPeriodoEscolar;
	private String identificacionAlumno;

	public MatriculaPK() {
	}

	public MatriculaPK(Long idAsignatura, Long idPeriodoEscolar, String identificacionAlumno) {
		super();
		this.idAsignatura = idAsignatura;
		this.idPeriodoEscolar = idPeriodoEscolar;
		this.identificacionAlumno = identificacionAlumno;
	}

	public Long getIdAsignatura() {
		return idAsignatura;
	}

	public void setIdAsignatura(Long idAsignatura) {
		this.idAsignatura = idAsignatura;
	}

	public Long getIdPeriodoEscolar() {
		return idPeriodoEscolar;
	}

	public void setIdPeriodoEscolar(Long idPeriodoEscolar) {
		this.idPeriodoEscolar = idPeriodoEscolar;
	}

	public String getIdentificacionAlumno() {
		return identificacionAlumno;
	}

	public void setIdentificacionAlumno(String identificacionAlumno) {
		this.identificacionAlumno = identificacionAlumno;
	}

}
