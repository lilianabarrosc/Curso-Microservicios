package com.lbarros.microservicio.matriculaComposer.consumer;

import java.util.Optional;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

import com.lbarros.microservicio.matriculaComposer.model.Alumno;
import com.lbarros.microservicio.matriculaComposer.model.Asignatura;
import com.lbarros.microservicio.matriculaComposer.model.Matricula;
import com.lbarros.microservicio.matriculaComposer.model.MatriculaPK;
import com.lbarros.microservicio.matriculaComposer.model.PeriodoEscolar;
import com.lbarros.microservicio.matriculaComposer.producer.EventSenderMessage;
import com.lbarros.microservicio.matriculaComposer.repository.AsignaturaRepository;
import com.lbarros.microservicio.matriculaComposer.repository.MatriculaRepository;
import com.lbarros.microservicio.matriculaComposer.repository.PeriodoEscolarRepository;

public class EventConsumer {
	
	@Autowired
	private MatriculaRepository matriculaRepository;
	
	@Autowired
	private AsignaturaRepository asignaturaRepository;
	
	@Autowired
	private PeriodoEscolarRepository periodoEscolarRepository;
	
	@Autowired
	private EventSenderMessage eventSenderMessage;

	@RabbitListener(queues="matriculaSAGA")
	public void receive(Alumno alumno) {
		try {
			Optional<Asignatura> asignatura = asignaturaRepository.findById(1);
			Optional<PeriodoEscolar> periodo = periodoEscolarRepository.findById(1);
			String identificacion = alumno.getNumeroIdentificacion() +  (!alumno.getDv().isEmpty()? alumno.getDv() : "");
			String nombre = alumno.getNombre() + " " + alumno.getApellidoPat() + " " + alumno.getApellidoMat();
			Matricula matricula = new Matricula(asignatura.get(), periodo.get(), identificacion, nombre);
			
			matriculaRepository.save(matricula);
			
			//enviar el evento
		    eventSenderMessage.sendMessage(matricula);
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	@RabbitListener(queues="rollbackMatricula")
	public void receiveRollback(Alumno alumno) {
		//transaccion de compensacion
		String identificacion = alumno.getNumeroIdentificacion() +  (!alumno.getDv().isEmpty()? alumno.getDv() : "");
		MatriculaPK pk = new MatriculaPK(1L,1L,identificacion);
		Optional<Matricula> matricula = matriculaRepository.findById(pk);
		matriculaRepository.delete(matricula.get());	
	}
}
