package com.lbarros.microservicio.matricula.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Asignatura")
public class Asignatura {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "creditos")
	private Long creditos;
	
	@ManyToOne
	@JoinColumn(name = "profesor_id", nullable=false)
	private Profesor profesor;

	public Asignatura(String nombre, Long creditos, Profesor profesor) {
		super();
		this.nombre = nombre;
		this.creditos = creditos;
		this.profesor = profesor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getCreditos() {
		return creditos;
	}

	public void setCreditos(Long creditos) {
		this.creditos = creditos;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	
}
