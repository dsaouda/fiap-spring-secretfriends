package com.github.dsaouda.fiap.spring.secretfriends;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
	
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
