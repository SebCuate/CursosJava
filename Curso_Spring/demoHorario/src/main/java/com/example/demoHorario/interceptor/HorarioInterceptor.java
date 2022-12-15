package com.example.demoHorario.interceptor;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component("Horario")
public class HorarioInterceptor implements HandlerInterceptor {

	@Value("${config.horario.apertura}")
	private Integer apertura;
	
	@Value("${config.horario.cierre}")
	private Integer cierre;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		Calendar calendar = Calendar.getInstance();
		int hora = calendar.get(Calendar.HOUR_OF_DAY);
		
		StringBuilder mensaje = new StringBuilder("Bienvenidos al servicio de atención a clientes");
		mensaje.append(", atendemos desde las ");
		mensaje.append(apertura);
		mensaje.append("hrs. hasta las ");
		mensaje.append(cierre);
		mensaje.append("hrs.");
		
		if(hora>= apertura && hora < cierre) {
			mensaje.append(" Gracias por su visita");
			mensaje.append(", ¿En que podemos ayudar?");
			request.setAttribute("mensaje", mensaje);
			return true;
		}
		
		mensaje.append(" Lamentamos no poder atenderle.");
		request.setAttribute("mensaje", mensaje);
		response.sendRedirect("/cerrado");
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		StringBuilder mensaje = (StringBuilder) request.getAttribute("mensaje");
		if(modelAndView != null)
			modelAndView.addObject("horario", mensaje.toString());
	}

	
}
