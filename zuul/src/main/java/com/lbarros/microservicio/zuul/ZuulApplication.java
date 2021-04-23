package com.lbarros.microservicio.zuul;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.lbarros.microservicio.zuul.fallbacks.MyFallbackProvider;
import com.lbarros.microservicio.zuul.filters.MiPostFiltro;
import com.lbarros.microservicio.zuul.filters.MiPreFiltro;


@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class ZuulApplication {
	private Date timeIni;

	public static void main(String[] args) {
		SpringApplication.run(ZuulApplication.class, args);
	}
	
	@Bean
	public MiPreFiltro miPreFiltro() {
		this.timeIni = new Date();
		return new MiPreFiltro();
	}
	
	@Bean
	public MiPostFiltro miPostFiltro() {
		return new MiPostFiltro(this.timeIni);
	}

	/*Solo se ejecutara para rutas validas, si no existe la ruta no se vera reflejado*/
	@Bean
	public MyFallbackProvider myFallback() {
		return new MyFallbackProvider();
	}

}
