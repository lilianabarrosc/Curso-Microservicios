package com.lbarros.microservicio.apiComposer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
@RibbonClients({@RibbonClient(name = "alumno-composer"), @RibbonClient(name = "matricula-composer")})
public class ApiComposerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiComposerApplication.class, args);
	}

}
