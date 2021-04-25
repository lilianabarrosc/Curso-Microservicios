package com.lbarros.microservicio.alumnos.model;

import java.sql.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import org.bson.types.ObjectId;

@Document(collection = "alumno")
public class Alumno {
	
	@Id 
	private String _id;
	private Long numeroIdentificacion;
	private String dv;
	private String nombre;
	private String apellidoPat;
	private String apellidoMat;
	private String ciudad;
	private String direcion;
	private String telefono;
	private Date fechaNacimiento;
	//private String sexo;
	
	public Alumno(String _id, Long numeroIdentificacion, String dv, String nombre, String apellidoPat, String apellidoMat, String ciudad, String direcion,
			String telefono, Date fechaNacimiento) {
		super();
		this.numeroIdentificacion = numeroIdentificacion;
		this.dv = dv;
		this.nombre = nombre;
		this.apellidoPat = apellidoPat;
		this.apellidoMat = apellidoMat;
		this.ciudad = ciudad;
		this.direcion = direcion;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
		this._id = _id;
	}
	
	public Alumno() {
		
	};

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public Long getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	public void setNumeroIdentificacion(Long numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}

	public String getDv() {
		return dv;
	}

	public void setDv(String dv) {
		this.dv = dv;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPat() {
		return apellidoPat;
	}

	public void setApellidoPat(String apellidoPat) {
		this.apellidoPat = apellidoPat;
	}

	public String getApellidoMat() {
		return apellidoMat;
	}

	public void setApellidoMat(String apellidoMat) {
		this.apellidoMat = apellidoMat;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDirecion() {
		return direcion;
	}

	public void setDirecion(String direcion) {
		this.direcion = direcion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
}