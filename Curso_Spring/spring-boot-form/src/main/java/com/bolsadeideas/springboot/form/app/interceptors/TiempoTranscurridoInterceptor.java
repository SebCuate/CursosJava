package com.bolsadeideas.springboot.form.app.interceptors;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component("tiempoTranscurridoInterceptor")
public class TiempoTranscurridoInterceptor implements HandlerInterceptor {

	private static final Logger logger = LoggerFactory.getLogger(TiempoTranscurridoInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		logger.info("TiempoTranscurridoInterceptor: entrando a preHandle()");
		long tiempoInicio = System.currentTimeMillis();
		request.setAttribute("tiempoInicio", tiempoInicio);
		
		if(request.getMethod().equalsIgnoreCase("post")) {
			return true;
		}
		
		Random random = new Random();
		Integer demora = random.nextInt(500);
		Thread.sleep(demora);
		
		return true; //continua con la ejecucion normal, false para terminar la petición
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		if(!request.getMethod().equalsIgnoreCase("post")) {
			return;
		}
		
		long tiempoInicio = System.currentTimeMillis();
		long tiempoFin = (Long) request.getAttribute("tiempoInicio");
		long tiempoTranscurrido = tiempoFin - tiempoInicio;
		
		request.setAttribute("tiempoInicio", tiempoFin);
		request.setAttribute("tiempoFin", tiempoFin);
		
		if(modelAndView != null) {
			modelAndView.addObject("tiempoTranscurrido", tiempoTranscurrido);
		}
		
		logger.info("Tiempo transcurrido: " + tiempoTranscurrido + " ms");
		logger.info("TiempoTranscurridoInterceptor: postHandle() saliendo");
	}

	
}
