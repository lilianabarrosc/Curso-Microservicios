package com.lbarros.microservicio.alumnoComposer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class AlumnoComposerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlumnoComposerApplication.class, args);
	}

}
