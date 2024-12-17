package com.mx.ApiGateway.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration //Notacion para decir que la clase es una configuracion
public class ConfiguracionCors implements WebMvcConfigurer{

	//Se esta configurando el cors del Apigateway para poder recivir peticiones http
	
	@Bean
	WebMvcConfigurer configurer() {
		return new WebMvcConfigurer() {
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")  //-------------------------------> Se manejara cualquier solicitud
				
						.allowedOrigins("http://localhost:4200/")//------------------------------------------------> origen donde se envia las peticiones http
						
						.allowedMethods("GET","PUT","DELETE","POST")//---------------------------------------> metodos que se manejaran
						
						.allowedHeaders("*")//---------> Se permiten todos los encabezados HTTP
						
						.allowCredentials(true) //------> Se permite recepcion de credenciales
						
						.maxAge(3600); //-----------> tiempo de espera
			}
		};
	}
	
	
	
}
