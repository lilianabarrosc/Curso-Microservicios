package com.lbarros.microservicio.matriculaComposer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MatriculaComposerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MatriculaComposerApplication.class, args);
	}

}
