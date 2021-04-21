package com.lbarros.microservicio.zuul.filters;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class MiPostFiltro extends ZuulFilter{
	
	private static Logger LOGGER = LoggerFactory.getLogger(MiPostFiltro.class);
    private static final String FILTERTYPE = "post";
    private static final Integer FILTERORDER = 1;
    private Date timeIni;
    String pattern = "MM/dd/yyyy HH:mm:ss";

    public MiPostFiltro(Date time){
    	this.timeIni = time;
    }
    
	@Override
	public boolean shouldFilter() {
		return true; //se aplique siempre
	}

	@Override
	public Object run() throws ZuulException {
		DateFormat df = new SimpleDateFormat(pattern);
		final HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		//se registra log de la peticion realizada
		LOGGER.info("Petición {} a {}", request.getMethod(), request.getRequestURL().toString());
		LOGGER.info("\n La petición inició {} y terminó {}", df.format(timeIni), df.format(new Date()));
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
