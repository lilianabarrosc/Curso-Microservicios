package com.lbarros.microservicio.apiComposer.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Alumno {
	
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
}