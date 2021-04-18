package com.lbarros.microservicio.matricula.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Periodo_escolar")
public class PeriodoEscolar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "periodo_inicio")
	private int periodoInicio;
	
	@Column(name = "periodo_fin")
	private int periodoFin;

	public PeriodoEscolar(int periodoInicio, int periodoFin) {
		super();
		this.periodoInicio = periodoInicio;
		this.periodoFin = periodoFin;
	}

	public Long getId() {
		return id;
	}

	public int getPeriodoInicio() {
		return periodoInicio;
	}

	public void setPeriodoInicio(int periodoInicio) {
		this.periodoInicio = periodoInicio;
	}

	public int getPeriodoFin() {
		return periodoFin;
	}

	public void setPeriodoFin(int periodoFin) {
		this.periodoFin = periodoFin;
	}

}
