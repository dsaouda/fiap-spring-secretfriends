package com.github.dsaouda.fiap.spring.secretfriends;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@SpringBootApplication
@EnableScheduling
public class App {
	
	@Bean
	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
	    ObjectMapper mapper = new ObjectMapper();
	    mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
	    MappingJackson2HttpMessageConverter converter = 
	        new MappingJackson2HttpMessageConverter(mapper);
	    return converter;
	}
	
	/*Não funcionou
	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
            	 registry.addMapping("/*")
            	 	.allowedOrigins("*")
            	 	.allowedMethods("*")
                 	.allowedHeaders("*")
                 	.allowCredentials(false)
                 	.maxAge(3600);
            }
        };
    }
    */
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(App.class, args);
	}
}
