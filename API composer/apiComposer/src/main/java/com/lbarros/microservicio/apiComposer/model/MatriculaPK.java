package com.lbarros.microservicio.apiComposer.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MatriculaPK {
	
	 private Long idAsignatura;
	 private Long idPeriodoEscolar;
	 private String identificacionAlumno;
	 
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
