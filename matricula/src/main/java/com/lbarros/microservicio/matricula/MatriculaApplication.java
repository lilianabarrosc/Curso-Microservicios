package com.lbarros.microservicio.matricula;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import com.lbarros.microservicio.matricula.config.RibbonConfigurator;


@EnableDiscoveryClient
@SpringBootApplication
//se decora para autenticacion
@EnableResourceServer
@RibbonClient(name = "restTemplate", configuration = {RibbonConfigurator.class})
@EnableCircuitBreaker
public class MatriculaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MatriculaApplication.class, args);
	}

}
