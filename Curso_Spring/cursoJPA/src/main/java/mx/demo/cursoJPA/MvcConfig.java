package mx.demo.cursoJPA;

import java.nio.file.Paths;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


//clase usada para carga de imagen funcionando como recurso del proyecto
@Configuration
public class MvcConfig implements WebMvcConfigurer{ //En versiones anteriores se EXTENDIA de WebMvcConfigurerAdapter

	/*
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.addResourceHandlers(registry);
		
		String resourcePath = Paths.get("uploads").toAbsolutePath()
					.toUri() //agrega el esquema file: al inicio de la ruta
					.toString();
		
		registry.addResourceHandler("/uploads/**")
//			.addResourceLocations("file:C:/opt/uploads/");
			.addResourceLocations(resourcePath);
	}*/

}
