package com.lbarros.microservicio.alumnoComposer.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.beans.factory.annotation.Autowired;

import com.lbarros.microservicio.alumnoComposer.model.Alumno;


public class EventSenderMessage {
	
	@Autowired
	private AmqpTemplate rabbitTemp;
	
	@Autowired
	private DirectExchange directExchange;
	
	public EventSenderMessage() {}
	
	public void sendMessage(Alumno alumno) {
		rabbitTemp.convertAndSend(directExchange.getName(),"matricula-composer", alumno);
	}
}
