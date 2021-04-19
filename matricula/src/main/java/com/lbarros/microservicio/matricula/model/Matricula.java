package com.lbarros.microservicio.matricula.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Matricula")
public class Matricula {
	// @Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	// private Long id_matricula;
	 
	 @ManyToOne
	 @JoinColumn(name = "fk_asignatura", nullable=false)
	 @PrimaryKeyJoinColumn
	 private Asignatura asignatura;
	 
	 @ManyToOne
	 @JoinColumn(name="fk_periodo_escolar", nullable=false)
	 @PrimaryKeyJoinColumn
	 private PeriodoEscolar periodoEscolar;
	 
	 @Id
	 @Column(name = "identificacion_alumno")
	 private String identificacionAlumno;
	 
	 @Column(name = "nombre_alumno")
	 private String nombreAlumno;

	public Matricula() {
	}

	public Matricula(Asignatura asignatura, PeriodoEscolar periodoEscolar, String identificacionAlumno,
			String nombreAlumno) {
		super();
		this.asignatura = asignatura;
		this.periodoEscolar = periodoEscolar;
		this.identificacionAlumno = identificacionAlumno;
		this.nombreAlumno = nombreAlumno;
	}

	/*
	public Long getId_matricula() {
		return id_matricula;
	}

	public void setId_matricula(Long id_matricula) {
		this.id_matricula = id_matricula;
	}

	public String getIdentificacionAlumno() {
		return identificacionAlumno;
	}
	 */
	public void setIdentificacionAlumno(String identificacionAlumno) {
		this.identificacionAlumno = identificacionAlumno;
	}

	public String getNombreAlumno() {
		return nombreAlumno;
	}

	public void setNombreAlumno(String nombreAlumno) {
		this.nombreAlumno = nombreAlumno;
	}

	public Asignatura getIdAsignatura() {
		return asignatura;
	}

	public void setIdAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	public PeriodoEscolar getIdPeriodoEscolar() {
		return periodoEscolar;
	}

	public void setIdPeriodoEscolar(PeriodoEscolar idPeriodoEscolar) {
		this.periodoEscolar = idPeriodoEscolar;
	}

	public String getIdentificacionAlumno() {
		return identificacionAlumno;
	}
	 
}
