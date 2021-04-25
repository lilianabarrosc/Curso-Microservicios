package com.lbarros.microservicio.matriculaComposer.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Autowired;

import com.lbarros.microservicio.matriculaComposer.model.Alumno;
import com.lbarros.microservicio.matriculaComposer.model.Matricula;


public class EventSenderMessage {
	
	@Autowired
	private AmqpTemplate rabbitTemp;
	
	@Autowired
	private DirectExchange directExchange;
	
	@Autowired
	private TopicExchange topicExchange;
	
	public EventSenderMessage() {}
	
	public void sendMessage(Matricula matricula) {
		rabbitTemp.convertAndSend(directExchange.getName(),"matricula-composer", matricula);
	}
	
	public void sendMessageRollback(Matricula matricula) {
		rabbitTemp.convertAndSend(topicExchange.getName(),"rollback.matricula", matricula);
	}
}
