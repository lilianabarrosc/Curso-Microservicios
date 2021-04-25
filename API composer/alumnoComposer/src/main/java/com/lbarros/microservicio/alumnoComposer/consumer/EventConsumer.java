package com.lbarros.microservicio.alumnoComposer.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.lbarros.microservicio.alumnoComposer.model.Alumno;

public class EventConsumer {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@RabbitListener(queues="rollbackAlumno")
	public void receive(Alumno alumno) {
		
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(alumno.get_id()));
		Update update = new Update();
		//TODO Crear actualizacion con cantidad de asignaturas tomadas por ejemplo para que cobre sentido,
		//por momento solo actualiza el mismo alumno
		mongoTemplate.updateFirst(query, update, Alumno.class);
	}

}
