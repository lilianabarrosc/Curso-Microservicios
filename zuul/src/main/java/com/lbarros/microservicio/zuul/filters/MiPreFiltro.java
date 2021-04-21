package com.lbarros.microservicio.zuul.filters;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class MiPreFiltro extends ZuulFilter{
	
	private static Logger LOGGER = LoggerFactory.getLogger(MiPreFiltro.class);
    private static final String FILTERTYPE = "pre";
    private static final Integer FILTERORDER = 1;

    public MiPreFiltro(){ }
    
	@Override
	public boolean shouldFilter() {
		boolean conteinsPostulante = RequestContext.getCurrentContext().getRequest().getRequestURI().startsWith("/postulante");
		boolean conteinsInscripcion = RequestContext.getCurrentContext().getRequest().getRequestURI().startsWith("/inscripcion");
		
		//se rechaza la peticion si en su cabecera no contiene la propiedad "postulante" o "inscripcion"
		return conteinsPostulante || conteinsInscripcion; 
	}

	@Override
	public Object run() throws ZuulException {
		final HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		LOGGER.info("Petición {} a {}", request.getMethod(), request.getRequestURL().toString());
		return null;
	}

	@Override
	public String filterType() {
		return FILTERTYPE;
	}

	@Override
	public int filterOrder() {
		return FILTERORDER;
	}

}
