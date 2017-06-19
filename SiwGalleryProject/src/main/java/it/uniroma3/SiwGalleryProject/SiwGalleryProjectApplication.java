package it.uniroma3.SiwGalleryProject;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@SpringBootApplication
@ComponentScan(basePackages="it.uniroma3.controller")
@EnableJpaRepositories(basePackages="it.uniroma3.repositories")
@EntityScan("it.uniroma3.model")


public class SiwGalleryProjectApplication {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
		return application.sources(SiwGalleryProjectApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(SiwGalleryProjectApplication.class, args);
	}
	
	
	
}
